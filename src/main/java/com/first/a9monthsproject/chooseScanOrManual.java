package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class chooseScanOrManual extends AppCompatActivity {

    private ImageButton logoButton;
    private Button scanButton;
    private Button manualBuuton;
    private TextView watchGeneralInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_scan_or_manual);

        logoButton = findViewById(R.id.Image_Logo);
        scanButton =(Button) findViewById(R.id.scan);
        manualBuuton =(Button) findViewById(R.id.manual);
        watchGeneralInfo = (TextView) findViewById(R.id.watchBloodTestInfo) ;

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScanResultImage();
            }
        });

        manualBuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManualResultImage();
            }
        });

        watchGeneralInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBloodTestsInfo();
            }
        });


    }

    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);

    }

    private void openScanResultImage() {
        Intent in = new Intent(this, scanResultPage.class);
        startActivity(in);
    }

    private void openManualResultImage() {
        Intent in = new Intent(this, Manual_blood_tests_result.class);
        startActivity(in);
    }

    private void openBloodTestsInfo() {
        Intent in = new Intent(this, Blood_TestGeneralInfo.class);
        startActivity(in);
    }
}
