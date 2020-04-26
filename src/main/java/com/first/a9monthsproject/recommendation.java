package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class recommendation extends AppCompatActivity {

    private Button urineRec;
    private Button bloodRec;
    private Button generalRec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        urineRec = findViewById(R.id.urineRes);
        bloodRec = findViewById(R.id.bloodRes);
        generalRec= findViewById(R.id.generalInfo);


        urineRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrineRecommendation();
            }
        });
        bloodRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBloodRecommendation();
            }
        });

        generalRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGeneralRecommendation();
            }
        });


    }



    private void openUrineRecommendation() {
        Intent in = new Intent( this,main_recommendation_urine.class);
        startActivity(in);
    }

    private void openBloodRecommendation() {
        Intent in = new Intent( this,main_recommendation_blood.class);
        startActivity(in);
    }
    private void openGeneralRecommendation() {
        Intent in = new Intent( this,main_recommendation_general.class);
        startActivity(in);
    }
}
