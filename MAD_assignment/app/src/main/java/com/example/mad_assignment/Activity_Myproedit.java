package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Activity_Myproedit extends AppCompatActivity {
    private EditText phoneNumbertx, userNametx,addresstx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__myproedit);
        phoneNumbertx=(EditText) findViewById(R.id.editTextmobilenum);
        userNametx= (EditText) findViewById(R.id.editTextTextPersonName);
        addresstx= (EditText) findViewById(R.id.editTextaddress);
//        Activity_Login_Background loginback = new Activity_Login_Background();
//        String phone = loginback.phoneNumber;
//        String password = loginback.password;
//        System.out.println(phone);
        ProfileEditOnLoadBackground profileback = new ProfileEditOnLoadBackground(this, phoneNumbertx, userNametx,addresstx);
        profileback.execute("+94711234566", "1234");

    }

}