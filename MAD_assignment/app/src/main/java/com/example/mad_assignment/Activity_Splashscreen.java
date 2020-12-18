package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Activity_Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Thread thread = new Thread() {

            @Override
            public void run() {try {sleep(1000);
                Intent intent = new Intent(getApplicationContext(), Activity_Login.class);
                startActivity(intent);
                finish();
            } catch(InterruptedException e){e.printStackTrace();
            }}
        };
        thread.start();
    }
}