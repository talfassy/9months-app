package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tests extends AppCompatActivity {

    private Button testLogButton;
    private Button infoBuuton;
    private Button watchResulButton;
    private Button testResultsBuuton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        testLogButton =(Button) findViewById(R.id.Testlog);
        infoBuuton =(Button) findViewById(R.id.Information);
        testResultsBuuton =(Button) findViewById(R.id.AddTestsresults);
        watchResulButton =(Button) findViewById(R.id.WatchTestsresults) ;


        infoBuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfoTestsPage();
            }
        });

        testResultsBuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTestResultPage();
            }
        });

        testLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTestLog();
            }
        });

        watchResulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWatchTestResult();
            }
        });
    }

    private void openWatchTestResult() {
        Intent in = new Intent(this, watch_tests_results.class);
        startActivity(in);
    }

    private void openTestLog() {

        Intent in = new Intent(this, testLog.class);
        startActivity(in);
    }

    private void openTestResultPage() {

        Intent in = new Intent(this, TestsResults.class);
        startActivity(in);
    }

    //use fun to move on to information about tests page
    public void openInfoTestsPage() {
        Intent in = new Intent(this, test_InfoPage.class);
        startActivity(in);
    }


}
