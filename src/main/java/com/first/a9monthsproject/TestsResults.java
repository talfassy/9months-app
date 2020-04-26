package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TestsResults extends AppCompatActivity {

    private Button bloodButton;
    private Button urineBuuton;
    private ImageButton logoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests_results);

        bloodButton =(Button) findViewById(R.id.bloodTest);
        urineBuuton =(Button) findViewById(R.id.urineTest);
        logoButton = findViewById(R.id.Image_Logo);

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        bloodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoosePage_blood();
            }
        });

        urineBuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoosePage_urine();
            }
        });
    }

    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);

    }

    private void openChoosePage_blood() {
        Intent in = new Intent(this, chooseScanOrManual.class);
        startActivity(in);
    }


    private void openChoosePage_urine() {
        Intent in = new Intent(this, choose_scan_or_manul_urine.class);
        startActivity(in);
    }

}
