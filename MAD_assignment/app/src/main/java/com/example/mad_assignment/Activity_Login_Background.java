package com.example.mad_assignment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;

public class Activity_Login_Background extends AsyncTask<String, Void, String> {
    Context context;
    ProgressDialog progressDialog;
    AlertDialog alertDialog;

    Activity_Login_Background(){}

    Activity_Login_Background(Context context){
        this.context= context;
    }



    @Override
    protected void onPreExecute() {
//        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Loading","Please wait");
        progressDialog.setTitle("Login");

        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Invalid");
    }

    @Override
    protected void onPostExecute(String result) {
//        super.onPostExecute(s);
        System.out.println(result);
        progressDialog.dismiss();
        if(result.equals("login success")){
            Intent i = new Intent(context,Activity_Myprofile.class);
            context.startActivity(i);
        }
        else{
            alertDialog.setMessage(result);
            alertDialog.show();;
        }
    }

    String phoneNumber;
    String password;

    @Override
    protected String doInBackground(String... strings) {
        //
        phoneNumber = strings[0];
        password = strings[1];
        String result = "";
        //
        try {
            //Connection to the php setup
            String LOGIN_URL = "http://192.168.1.100/testapp/userlogin.php";
            URL url = new URL(LOGIN_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            // data to be output to the php
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
//
            String Data = URLEncoder.encode("phoneNumber", "UTF-8") + "=" + URLEncoder.encode(phoneNumber, "UTF-8") + "&&"
                    + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
//
            bufferedWriter.write(Data);
            bufferedWriter.flush();

            bufferedWriter.close();
            outputStream.close();

//data input to the application from the DB
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1"));
            String output = "";
            while ((output = bufferedReader.readLine()) != null) {
                result = result + output;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
