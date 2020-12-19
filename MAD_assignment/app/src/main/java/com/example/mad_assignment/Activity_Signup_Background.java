package com.example.mad_assignment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.LinearLayout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Activity_Signup_Background extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;
    ProgressDialog progressDialog;
    static public String IP_ADDREDS;

    public Activity_Signup_Background(){
    }

    public Activity_Signup_Background(Context context){
        this.context=context;
    }


    @Override
    protected String doInBackground(String... strings) {

        String fullname=strings[0];
        String address=strings[1];
        String MobileNo=strings[2];
        String password=strings[3];

        String result="";

            try {
                String connect ="http://"+IP_ADDREDS+"/finepay/usersignup.php";
                URL url = new URL(connect);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("fullname", "UTF-8") + "=" + URLEncoder.encode(fullname, "UTF-8") + "&&"
                        + URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&&"
                        + URLEncoder.encode("MobileNo", "UTF-8") + "=" + URLEncoder.encode(MobileNo, "UTF-8") + "&&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&&"
                       ;

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1"));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                result = e.getMessage();
            } catch (IOException e) {
                result = e.getMessage();
            }

        return result;
    }


    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(context, "ProgressDialog", "Please Wait");
        progressDialog.setTitle("Registering");
        progressDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
  //      progressDialog.getWindow().setBackgroundDrawableResource(R.drawable.white_button);
//        alertDialog = new AlertDialog.Builder(context).create();
//        alertDialog.setTitle("");
//        alertDialog.setIcon(R.drawable.error_alertbox_icon);
//        alertDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//        alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.white_button);
    }

    @Override
    protected void onPostExecute(String result) {
        String res=result;
        progressDialog.dismiss();

        if(res.equals("Register Complete")){

            final androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
            builder.setTitle("");
            builder.setMessage(result);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.app_name, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent= new Intent(context,Activity_Splashscreen.class);
                    context.startActivity(intent);
                }
            });
            builder.show();
        }
        else{
//            alertDialog.setMessage(result);
//            alertDialog.show();
        }
    }
}


