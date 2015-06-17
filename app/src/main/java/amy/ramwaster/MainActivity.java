package amy.ramwaster;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    //creates memory leak and terminates when a specified of RAM is being used

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("helloooo");
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        MemoryLeaker m = new MemoryLeaker(activityManager);
        System.out.print("end");
        System.out.print("end");
        System.out.print("end");
        System.out.print("end");
        finish();
    }


    /**
     * Created by appleowner on 6/17/15.
     */
    public static class MemoryLeaker {

        //creates a memory leak
        //heavily inspired by http://java.dzone.com/articles/how-create-memory-leak

        public MemoryLeaker(ActivityManager activityManager) {
            Map m = new HashMap();
            while (true) {

                ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(mi);
                long availableMemory = mi.availMem / 1048576L;
                long totalMemory = mi.totalMem/1048576L;
                System.out.println(totalMemory);
                System.out.println(availableMemory);
                double percentRAM = ((double) (totalMemory - availableMemory)/totalMemory) * 100;
                System.out.println(percentRAM);
                if (percentRAM > 70) {
                    System.out.println("at 210");
                    break;
                }

                for (int i=0; i < 10000; i++) {

                    if (!m.containsKey(i)) {
                        m.put(new Key(i), "Number: " + i);
                    }
                }
            }
        }

        static class Key {
            Integer id;

            Key(Integer id) {
                this.id = id;
            }

            @Override
            public int hashCode() {
                return id.hashCode();
            }
        }

    }
}
