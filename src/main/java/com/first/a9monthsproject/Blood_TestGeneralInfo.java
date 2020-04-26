package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Blood_TestGeneralInfo extends AppCompatActivity {

    private ImageButton logoButton;
    private TextView returnButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood__test_general_info);

        returnButton= (TextView) findViewById(R.id.returnTestPage);
        logoButton = (ImageButton) findViewById(R.id.Image_Logo);

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTests();
            }
        });
    }

    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }

    private void openTests() {
        Intent in = new Intent(this, tests.class);
        startActivity(in);
    }
}
