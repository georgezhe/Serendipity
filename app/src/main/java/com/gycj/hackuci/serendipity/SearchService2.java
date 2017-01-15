package com.gycj.hackuci.serendipity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class SearchService2 extends Service {
    public SearchService2() {
    }
    final class myThread implements Runnable{
        int startId;
        public myThread(int startId){
            this.startId=startId;
        }
        @Override
        public void run() {
            synchronized (this){
                try{
                    wait(100000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                stopSelf(startId);
            }
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID)
    {
        //George: ADD YOUR CODE HERE!!!
        Toast.makeText(SearchService2.this,"Service Started!!!!",Toast.LENGTH_SHORT).show();

        Thread thread = new Thread(new myThread(startID));
        thread.start();
        return super.onStartCommand(intent,flags,startID);
    }


    @Override
    public void onDestroy()
    {
        //George: ADD YOUR CODE HERE!!!!
        Toast.makeText(SearchService2.this,"Service Stopped!!!!",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
