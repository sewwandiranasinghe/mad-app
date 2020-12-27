package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Activity_Myproedit extends AppCompatActivity {
    private EditText phoneNumbertx, userNametx,addresstx,bikenametx,bikemodeltx,regnotx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__myproedit);
        phoneNumbertx=(EditText) findViewById(R.id.editTextmobilenum);
        userNametx= (EditText) findViewById(R.id.editTextTextPersonName);
        addresstx= (EditText) findViewById(R.id.editTextaddress);
        bikenametx= (EditText) findViewById(R.id.editTextbikename);
        bikemodeltx= (EditText) findViewById(R.id.editTextbikemodel);
       regnotx= (EditText) findViewById(R.id.editTextregnum);


//        Activity_Login_Background loginback = new Activity_Login_Background();
//        String phone = loginback.phoneNumber;
//        String password = loginback.password;
//        System.out.println(phone);
        ProfileEditOnLoadBackground profileback = new ProfileEditOnLoadBackground(this, phoneNumbertx, userNametx,addresstx,bikenametx,bikemodeltx,regnotx);
        profileback.execute("+94711234566", "1234","No310 hidellana rd,ratnapura","Honda","Hornet","BCD-0217");

    }

}