package com.example.mad_assignment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ProfileEditOnLoadBackground extends AsyncTask<String, Void, String> {
    Context context;
    EditText phoneNumbertx, userNametx,addresstx,bikenametx;
    ProgressDialog progressDialog;
    AlertDialog alertDialog;

    ProfileEditOnLoadBackground(Activity_Myproedit activity_myproedit, EditText phoneNumbertx, EditText userNametx, EditText addresstx,EditText bikenametx){}
    ProfileEditOnLoadBackground(Context context, EditText phoneNumber, EditText userName,EditText address,EditText bikeName) {
        this.context=context;
        this.phoneNumbertx = phoneNumber;
        this.userNametx = userName;
        this.addresstx=address;
        this.bikenametx=bikeName;
    }

    @Override
    protected void onPreExecute() {
       // super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Loading","Please wait");
        progressDialog.setTitle("Login");

        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Invalid Mobile No or Password");
    }

    @Override
    protected void onPostExecute(String result) {
       // super.onPostExecute(s);
        System.out.println(result);
        progressDialog.dismiss();
        loadIntodata(result);
    }

    private void loadIntodata(String json) {
        try{
            JSONArray jsonArray = new JSONArray(json);
            String[] phone = new String[jsonArray.length()];
            String[] name = new String[jsonArray.length()];
            String[] address = new String[jsonArray.length()];
            String[] bikeName = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                phone[i] = obj.getString("phone_no");
                name[i]= obj.getString("fullName");
                address[i]= obj.getString("address");
                bikeName[i]= obj.getString("bikeName");

            }
            System.out.println(phone[0].toString());
            phoneNumbertx.setText(phone[0].toString());
            userNametx.setText(name[0].toString());
            addresstx.setText(name[0].toString());
            bikenametx.setText(name[0].toString());

//            nametx.setText(name[0].toString());
//            emailtx.setText(email[0].toString());
//            phonenumbertx.setText(phonenumber[0].toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }}

    @Override
    protected String doInBackground(String... strings) {
        System.out.println(phoneNumbertx.getText());
        String phoneNumber = strings[0];
        String password = strings[1];
        String result = "";
        //
        try {
            //Connection to the php setup
            String LOGIN_URL = "http://192.168.42.2/testapp/useronloaddata.php";
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
