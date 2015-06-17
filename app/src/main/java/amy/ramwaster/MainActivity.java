package amy.ramwaster;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;
import java.util.Map;


import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import android.graphics.BitmapFactory;
import java.io.IOException;
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




    public void runRamCheck(long memory) {
        //spaceWaster = new ArrayList<String>();
        memory = memory;
        threadCount = 0;
        System.out.println("available megs: " + memory);
        while (memory > 250L) {
            //getBitmapFromURL();
            threadCount += 1;
            threadMaker();
            memory = checkMemory();
            if (memory % 2L == 0) {
                System.out.println("available megs: " + memory);
            }
            //System.out.println("available megs: " + memory);
        }
        finish();

        //TextView mediumText = (TextView) findViewById(R.id.medium_text);
        //String currentMem = String.valueOf(checkMemory());
        //mediumText.setText(currentMem);
    }

    public long checkMemory() {
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        long availableMegs = mi.availMem / 1048576L;
        System.out.println(availableMegs);
        //Percentage can be calculated for API 16+
        //System.out.println(mi.availMem);
        //long percentAvail = mi.availMem / mi.totalMem *100;
        //System.out.println("total memory");
        //System.out.println(mi.totalMem/1048576);
        //System.out.println("percent left");
        //System.out.println(percentAvail);
        return availableMegs;
    }


    public void threadMaker() {
        new Thread(new Runnable() {
            public void run() {
                int i = 2;
                //ArrayList<String> array = new ArrayList<String>();
                int z = 20922;
                int y = 2101012;
                int p = 0;
                while (i < 1000) {
                    //threadMaker();
                    p = z* y;
                    //System.out.println("new thread " + threadCount);
                    //array.add("hello");
                    long memory = checkMemory();
                    //System.out.println("available megs: " + memory);
                    if (memory == 315) {
                        System.out.println("available megs: " + memory);
                    }

                    if (memory == 300) {
                        System.out.println("available megs: " + memory);
                    }
                    if (memory == 250) {
                        System.out.println("available megs: " + memory);
                    }
                    //System.out.println("available megs: " + memory);
                    //threadMaker();
                    //i++;
                }
            }
        }).start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Created by appleowner on 6/17/15.
     */
    public static class MemoryLeaker {

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
