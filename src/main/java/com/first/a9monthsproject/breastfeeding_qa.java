package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class breastfeeding_qa extends AppCompatActivity {

    private Button returnButton;
    private ImageButton logoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breastfeeding_qa);

        returnButton= (Button) findViewById(R.id.goback);
        logoButton=(ImageButton) findViewById(R.id.Image_Logo);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQApage();
            }
        });

        //move to home page when we push on the logo
        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
    }


    //use fun to move on to main QA page
    public void openQApage() {
        Intent in = new Intent(this, questionsAnswers.class);
        startActivity(in);
    }

    //use fun to move on to home page
    public void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }
}
