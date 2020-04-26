package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class afterBirthQA extends AppCompatActivity {

    private Button returnButton;
    private ImageButton logoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_birth_q);

        returnButton =(Button) findViewById(R.id.goback);
        logoButton = (ImageButton) findViewById(R.id.Image_Logo);

        //return to answers and questions page
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQAlist();
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

    //open the main page of answers and questions
    private void openQAlist() {
        Intent in = new Intent(this, questionsAnswers.class);
        startActivity(in);
    }

}
