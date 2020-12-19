package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity_Signup extends AppCompatActivity {

    private EditText fullnametx,addresstx,mobilenotx,passtx;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        fullnametx = (EditText) findViewById(R.id.fullnametx);
        addresstx = (EditText) findViewById(R.id.addresstx);
        mobilenotx = (EditText) findViewById(R.id.mobilenotx);
        passtx = (EditText) findViewById(R.id.passtx);






    }


    public void back_btn(View view) {
        Intent intent = new Intent(Activity_Signup.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
    }

    public void signup(View view) {

        String fullname = fullnametx.getText().toString().trim();
        String address = addresstx.getText().toString().trim();
        String MobileNo = mobilenotx.getText().toString().trim();


        String password = passtx.getText().toString().trim();


        /** Error Message Icon **/
        Drawable warning = (Drawable)getResources().getDrawable(R.drawable.signup_error_icon);
        warning.setBounds(0, 0, warning.getIntrinsicWidth(), warning.getIntrinsicHeight());

        /** Validating Fields **/
        if (TextUtils.isEmpty(fullname) || TextUtils.isEmpty(address) || TextUtils.isEmpty(MobileNo)
                || TextUtils.isEmpty(password) ) {
            fullnametx.setError("Name",warning);
            addresstx.setError("Email",warning);
            mobilenotx.setError("Phone Number",warning);

            passtx.setError("Password",warning);

        } else if (TextUtils.isEmpty(fullname)) {
            fullnametx.setError("Enter Name",warning);
        } else if (TextUtils.isEmpty(address)) {
           addresstx.setError("Enter your Address",warning);
        } else if (TextUtils.isEmpty(MobileNo)) {
            mobilenotx.setError("Enter Phone Number",warning);

        } else if (TextUtils.isEmpty(password)) {
            passtx.setError("Enter Password",warning);



            Activity_Signup_Background activity_signup_background  = new activity_signup_background(this);
            activity_signup_background.execute(fullname,address,MobileNo,password);

        }


    }









}