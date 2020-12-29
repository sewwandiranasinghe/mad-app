package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_Services extends AppCompatActivity {
    private RadioButton mfullservice,mregularservice;
    private CheckBox moilchange,mfilters,mnormalwash,mrepairdamages,mpaint,mrecoveryservices;
    private TextView mResultTextView;
    private ArrayList <String> mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        mfullservice=findViewById(R.id.full_service);
        mregularservice=findViewById(R.id.regular_service);

        moilchange=findViewById(R.id.oil_change);
        mfilters=findViewById(R.id.filter);
        mnormalwash=findViewById(R.id.normal_wash);
        mrepairdamages=findViewById(R.id.repair_damages);
        mpaint=findViewById(R.id.paint);
        mrecoveryservices=findViewById(R.id.recovery_service);

        moilchange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (moilchange.isChecked())
                    mResult.add("oil changes");
                else
                    mResult.remove("oil changes");

            }

        });
        mfilters.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (mfilters.isChecked())
                    mResult.add("filters");
                else
                    mResult.remove("filters");

            }

        });
        mnormalwash.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (mnormalwash.isChecked())
                    mResult.add("normal wash");
                else
                    mResult.remove("normal wash");

            }

        });

        mrepairdamages.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (mrepairdamages.isChecked())
                    mResult.add("repair damages");
                else
                    mResult.remove("repair damages");

            }

        });

        mpaint.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (mpaint.isChecked())
                    mResult.add("paints");
                else
                    mResult.remove("paints");

            }

        });

        mrecoveryservices.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (mrecoveryservices.isChecked())
                    mResult.add("recovery services");
                else
                    mResult.remove("recovery services");

            }

        });
    }

    public void bookbutton(View view) {
        Intent intent = new Intent(Activity_Services.this, Activity_Easy.class);
        startActivity(intent);
    }
}