package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
    }

    public void bookbutton(View view) {
        Intent intent = new Intent(Activity_Services.this, Activity_Easy.class);
        startActivity(intent);
    }
}