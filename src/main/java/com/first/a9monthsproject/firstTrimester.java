package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class firstTrimester extends AppCompatActivity {

    private Button returnMainTests;
    private Button returnTestslist;
    private ImageButton logoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_trimester);

        returnMainTests = (Button) findViewById(R.id.returnMainArticles);
        returnTestslist =(Button) findViewById(R.id.testList);
        logoButton = (ImageButton) findViewById(R.id.Image_Logo);

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

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
    }

    //open the main openHomePage()
    private void openHomePage(){
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
