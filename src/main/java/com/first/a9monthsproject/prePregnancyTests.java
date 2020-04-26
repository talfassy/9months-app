package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class prePregnancyTests extends AppCompatActivity {

    private Button returnMainTests;
    private Button returnTestslist;
    private ImageButton logoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_pregnancy_tests);

        returnMainTests = (Button) findViewById(R.id.returnMainTests);
        returnTestslist =(Button) findViewById(R.id.gobackToListOfTests);
        logoButton =(ImageButton) findViewById(R.id.Image_Logo);

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        returnTestslist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfoOfTests();
            }
        });

        returnMainTests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opemTestsPage();
            }
        });
    }

    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }

    //open the main tests page
    private void opemTestsPage() {
        Intent in = new Intent(this, tests.class);
        startActivity(in);
    }

    //open the list of all trimestrs
    private void openInfoOfTests() {
        Intent in = new Intent(this, test_InfoPage.class);
        startActivity(in);
    }
}
