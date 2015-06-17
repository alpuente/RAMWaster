package amy.ramwaster;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    public int threadCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("helloooo");
        //getBitmapFromURL();
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        MemoryLeaker m = new MemoryLeaker(activityManager);
        //runRamCheck(checkMemory());
        System.out.print("end");
        System.out.print("end");
        System.out.print("end");
        System.out.print("end");
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    /**
     * Created by appleowner on 6/17/15.
     */
    public static class MemoryLeaker {

        //creates a memory leak
        //heavily 

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
