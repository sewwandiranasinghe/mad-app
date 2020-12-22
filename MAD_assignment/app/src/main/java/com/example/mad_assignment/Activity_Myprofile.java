package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Myprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
    }

    public void viewbutton(View view) {
        Intent intent = new Intent(Activity_Myprofile.this, Activity_Licencereview.class);
        startActivity(intent);
    }

    public void editprofilebutton(View view) {
        Intent intent = new Intent(Activity_Myprofile.this, Activity_Myproedit.class);
        startActivity(intent);
    }
}