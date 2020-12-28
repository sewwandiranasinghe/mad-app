package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Paymentsummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentsummary);
    }

    public void cashpaybutton(View view) {
        Intent intent = new Intent(Activity_Paymentsummary.this, Activity_Paymentsummary_Cash.class);
        startActivity(intent);
    }
}