package com.example.mainthreadfreezecustomthreadclass;


import android.util.Log;
import android.widget.Toast;

public class WorkerThread extends Thread{

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(5000);
            Log.i("___","Worker Thread done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
