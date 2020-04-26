package com.first.a9monthsproject;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class watch_tests_results extends AppCompatActivity {

    private Button blood;
    private Button urine;
    private ImageButton logoButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_tests_results);

        blood = findViewById(R.id.bloodTest);
        urine = findViewById(R.id.urineTest);
        logoButton = findViewById(R.id.Image_Logo);

        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBlooddecoding();
            }
        });

        urine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrineDecoding();
            }
        });

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

    }

    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);

    }

    private void openUrineDecoding() {
        Intent in = new Intent(this, decodingResults_urine.class);
        startActivity(in);
    }

    private void openBlooddecoding() {
        Intent in = new Intent(this, decodingResults.class);
        startActivity(in);
    }




}
