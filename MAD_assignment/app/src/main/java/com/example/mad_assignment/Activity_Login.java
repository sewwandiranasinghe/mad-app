package com.example.mad_assignment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class Activity_Login extends AppCompatActivity {
    public EditText phonetx, passwordtx;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Window w = getWindow();
//        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        w.setStatusBarColor(getResources().getColor(R.color.yellow2));

        phonetx=(EditText)findViewById(R.id.phonetx);
        passwordtx=(EditText)findViewById(R.id.passwordtx);
    }

    public void LoginBtnOnClicl(View view) {
        String phoneNumber = phonetx.getText().toString().trim();
        String password = passwordtx.getText().toString().trim();

        Activity_Login_Background loginBackground = new Activity_Login_Background(this);
        loginBackground.execute(phoneNumber, password);

    }



    public void onSignInClick(View view) {
        Intent intent = new Intent(Activity_Login.this, Activity_Forgotpass.class);
        startActivity(intent);
    }
}