package com.example.mainthreadfreezecustomthreadclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    public final String awake="MainThread now Awake";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
//        Custom Worker Thread to sleep for 5 seconds
        WorkerThread workerThread=new WorkerThread();
        workerThread.start();
//        Worker Thread ends

        Toast.makeText(this, "MainThread will Freeze for 10seconds", Toast.LENGTH_SHORT).show();

//        MainThread to freeze after 15seconds of Launch
        Handler handler=new Handler(getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "MainThread Awake", Toast.LENGTH_SHORT).show();
                textView.setText(awake);
            }
        },15000);
//        After 10 seconds MainThread Awakes

    }
}