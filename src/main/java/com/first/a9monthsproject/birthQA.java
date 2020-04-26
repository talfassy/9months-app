package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class birthQA extends AppCompatActivity {

    private Button returnButton;
    private ImageButton logoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_q);

        returnButton =(Button) findViewById(R.id.goback);
        logoButton =(ImageButton) findViewById(R.id.Image_Logo);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQApage();
            }
        });

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
    }

    //open home page
    private void openHomePage(){
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }

    //open main QA page
    private void openQApage(){
        Intent in = new Intent(this, questionsAnswers.class);
        startActivity(in);
    }

}
