package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_Orders extends AppCompatActivity {
    private CheckBox nbuzzer,ncrashguard,nengineguard,nfrontlinerbox,ngearlever,nhandgrip,nhelmetlock,nhelmet,nnumberplatecover,npillionholder,nseatcover,ntankcover,nbrakepads,nsignallightcup,nheadlight;
    private TextView nResultTextView;
    private ArrayList<String> nResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        nbuzzer=findViewById(R.id.buzzer);
        ncrashguard=findViewById(R.id.crashguard);
        nengineguard=findViewById(R.id.enginneguard);
        nfrontlinerbox=findViewById(R.id.frontliner);
        ngearlever=findViewById(R.id.gearlever);
        nhandgrip=findViewById(R.id.handgrip);
        nhelmetlock=findViewById(R.id.helmetlock);
        nhelmet=findViewById(R.id.helmet);
        nnumberplatecover=findViewById(R.id.numberplate);
        npillionholder=findViewById(R.id.pillionholder);
        nseatcover=findViewById(R.id.seatcover);
        ntankcover=findViewById(R.id.tankcover);
        nbrakepads=findViewById(R.id.brakepad);
        nsignallightcup=findViewById(R.id.signallightcup);
        nheadlight=findViewById(R.id.headlight);

        nbuzzer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (nbuzzer.isChecked())
                    nResult.add("Buzzer");
                else
                    nResult.remove("Buzzer");

            }

        });

        ncrashguard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (ncrashguard.isChecked())
                    nResult.add("Crash guard");
                else
                    nResult.remove("Crash guard");

            }

        });

        nengineguard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (nengineguard.isChecked())
                    nResult.add("Engine guard");
                else
                    nResult.remove("Engine guard");

            }

        });
        nfrontlinerbox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (nfrontlinerbox.isChecked())
                    nResult.add("Front liner box");
                else
                    nResult.remove("Front liner box");

            }

        });
        ngearlever.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (ngearlever.isChecked())
                    nResult.add("Gear lever");
                else
                    nResult.remove("Gear lever");

            }

        });
        nhandgrip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (nhandgrip.isChecked())
                    nResult.add("Hand grip");
                else
                    nResult.remove("Hand grip");

            }

        });
        nhelmetlock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (nhelmetlock.isChecked())
                    nResult.add("Helmet lock");
                else
                    nResult.remove("Helmet lock");

            }

        });
        nhelmet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (nhelmet.isChecked())
                    nResult.add("Helmet ");
                else
                    nResult.remove("Helmet ");

            }

        });
        nnumberplatecover.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (nnumberplatecover.isChecked())
                    nResult.add("Number plate cover");
                else
                    nResult.remove("Number plate cover");

            }

        });
        npillionholder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (npillionholder.isChecked())
                    nResult.add("pillion holder");
                else
                    nResult.remove("pillion holder");

            }

        });
        nseatcover.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (nseatcover.isChecked())
                    nResult.add("seat cover");
                else
                    nResult.remove("seat cover");

            }

        });
      ntankcover.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (ntankcover.isChecked())
                    nResult.add("Tank cover");
                else
                    nResult.remove("Tank cover");

            }

        });
        nbrakepads.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (nbrakepads.isChecked())
                    nResult.add("Brake pad");
                else
                    nResult.remove("Brake pad");

            }

        });

        nsignallightcup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (nsignallightcup.isChecked())
                    nResult.add("Signal light Cup");
                else
                    nResult.remove("Signal light Cup");

            }

        });
        nheadlight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (nheadlight.isChecked())
                    nResult.add("Head light");
                else
                    nResult.remove("Head light");

            }

        });

    }
}