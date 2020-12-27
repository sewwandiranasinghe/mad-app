package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class Activity_Signup extends AppCompatActivity {

    private EditText fullnametx,addresstx,mobilenotx,passtx,bikenametx,bikemodeltx,registrationnotx;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        fullnametx = (EditText) findViewById(R.id.fullnametx);
        addresstx = (EditText) findViewById(R.id.addresstx);
        mobilenotx = (EditText) findViewById(R.id.mobilenotx);
        passtx = (EditText) findViewById(R.id.passtx);
        bikenametx = (EditText) findViewById(R.id.bikenametx);
        bikemodeltx = (EditText) findViewById(R.id.bikemodeltx);
       registrationnotx = (EditText) findViewById(R.id.registrationnotx);






    }


    public void back_btn(View view) {
        Intent intent = new Intent(Activity_Signup.this, Activity_Splashscreen.class);
        startActivity(intent);
//        overridePendingTransition(R.anim.slide_up, R.anim.fade_out);
    }

    public void signup(View view) {

        String fullname = fullnametx.getText().toString().trim();
        String address = addresstx.getText().toString().trim();
        String MobileNo = mobilenotx.getText().toString().trim();
        String BikeName = bikenametx.getText().toString().trim();
        String BikeModel = bikemodeltx.getText().toString().trim();
        String RegistrationNo = registrationnotx.getText().toString().trim();


        String password = passtx.getText().toString().trim();


        /** Error Message Icon **/
        Drawable warning = (Drawable)getResources().getDrawable(R.drawable.button_arrow);
        warning.setBounds(0, 0, warning.getIntrinsicWidth(), warning.getIntrinsicHeight());

        /** Validating Fields **/
        if (TextUtils.isEmpty(fullname) || TextUtils.isEmpty(address) || TextUtils.isEmpty(MobileNo)
                || TextUtils.isEmpty(password) ) {
            fullnametx.setError("Name",warning);
            addresstx.setError("Email",warning);
            mobilenotx.setError("Phone Number",warning);
            bikenametx.setError("BikeName",warning);
            bikemodeltx.setError("BikeModel",warning);
            registrationnotx.setError("RegistrationNo",warning);

            passtx.setError("Password",warning);

        } else if (TextUtils.isEmpty(fullname)) {
            fullnametx.setError("Enter Name",warning);
        } else if (TextUtils.isEmpty(address)) {
           addresstx.setError("Enter your Address",warning);
        } else if (TextUtils.isEmpty(MobileNo)) {
            mobilenotx.setError("Enter Phone Number",warning);

        } else if (TextUtils.isEmpty(password)) {
            passtx.setError("Enter Password",warning);
        } else if (TextUtils.isEmpty(BikeName)) {
            bikenametx.setError("Enter BikeName",warning);
        } else if (TextUtils.isEmpty(BikeModel)) {
            bikemodeltx.setError("Enter BikeModel",warning);
        } else if (TextUtils.isEmpty(RegistrationNo)) {
           registrationnotx.setError("Enter RegistrationNo",warning);


//            Activity_Signup_Background activity_signup_background  = new activity_signup_background(this);
//            activity_signup_background.execute(fullname,address,MobileNo,password);

        }


    }


    public void onSignUpClick(View view) {
        Intent intent = new Intent(Activity_Signup.this, Activity_Login.class);
        startActivity(intent);
    }
}