package com.gycj.hackuci.serendipity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.InjectView;

public class LoadingScreen extends AppCompatActivity {
    public Button testbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        testbutton = (Button) findViewById(R.id.btn_load);
        testbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                if(testbutton.getText().equals("Start"))
                {
                    start();
                }
                else
                {
                    stop();
                }
            }
        });
    }
    public void start()
    {
        Intent i = new Intent(getApplicationContext(),SearchService2.class);
        startService(i);
        testbutton.setText("Stop");
    }
    public void stop()
    {
        Intent j = new Intent(getApplicationContext(),SearchService2.class);
        stopService(j);
        testbutton.setText("Start");
    }
}
