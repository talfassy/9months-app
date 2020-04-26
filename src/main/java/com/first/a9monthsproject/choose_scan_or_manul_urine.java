package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class choose_scan_or_manul_urine extends AppCompatActivity {

    private Button scanButton;
    private Button manualButton;
    private ImageButton logoButton;
    private TextView watchGeneralInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_scan_or_manul_urine);

        scanButton =(Button) findViewById(R.id.scan);
        manualButton =(Button) findViewById(R.id.manual);
        logoButton= findViewById(R.id.Image_Logo);
        watchGeneralInfo = (TextView) findViewById(R.id.watchBloodTestInfo2) ;

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScanResultUrine();

            }
        });

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        watchGeneralInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBloodTestsInfo();
            }
        });

        manualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddManuallyUrineTests();
            }
        });


    }

    private void openAddManuallyUrineTests() {
        Intent in = new Intent(this, manual_urine_tests_results.class);
        startActivity(in);
    }

    private void openBloodTestsInfo() {
        Intent in = new Intent(this, Urine_testsgeneralInfo.class);
        startActivity(in);
    }

    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);

    }

    private void openScanResultUrine() {
        Intent in = new Intent(this, scanResults_urine.class);
        startActivity(in);
    }
}
