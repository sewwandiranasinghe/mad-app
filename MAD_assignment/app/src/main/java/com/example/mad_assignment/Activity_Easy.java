package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Easy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__easy);
    }

    public void bookservicebutton(View view) {
        Intent intent = new Intent(Activity_Easy.this, Activity_Services.class);
        startActivity(intent);
    }

    public void freepickupbutton(View view) {
        Intent intent = new Intent(Activity_Easy.this, Activity_Login.class);
        startActivity(intent);
    }

    public void billservicebutton(View view) {
        Intent intent = new Intent(Activity_Easy.this, Activity_Billingdetails.class);
        startActivity(intent);
    }

    public void detailcheckupbutton(View view) {
        Intent intent = new Intent(Activity_Easy.this, Activity_Billingdetails.class);
        startActivity(intent);
    }

    public void ordersparebutton(View view) {
        Intent intent = new Intent(Activity_Easy.this, Activity_Orders.class);
        startActivity(intent);

    }

    public void trackbikebutton(View view) {
        Intent intent = new Intent(Activity_Easy.this, Activity_Billingdetails.class);
        startActivity(intent);
    }

    public void paymentorderbutton(View view) {
        Intent intent = new Intent(Activity_Easy.this, Activity_Payorders.class);
        startActivity(intent);
    }

    public void freedropbutton(View view) {
        Intent intent = new Intent(Activity_Easy.this, Activity_Billingdetails.class);
        startActivity(intent);
    }
}