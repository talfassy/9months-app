package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class triedTrimesterTests extends AppCompatActivity {

    private Button returnMainTests;
    private Button returnTestslist;
    private ImageButton logoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tried_trimester_tests);

        returnMainTests = (Button) findViewById(R.id.returnMainArticles);
        returnTestslist =(Button) findViewById(R.id.testList);
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
                openTestsPage();
            }
        });
    }

    //open the main tests page
    private void openTestsPage() {
        Intent in = new Intent(this, tests.class);
        startActivity(in);
    }

    //open the home page
    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }

    //open the list of all trimestrs
    private void openInfoOfTests() {
        Intent in = new Intent(this, test_InfoPage.class);
        startActivity(in);
    }
}
