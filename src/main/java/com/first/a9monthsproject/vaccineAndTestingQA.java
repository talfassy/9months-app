package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class vaccineAndTestingQA extends AppCompatActivity {


   private ImageButton logoButton;
    private Button returnButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_and_testing_q);


       logoButton=(ImageButton) findViewById(R.id.Image_Logo);
        returnButton =(Button) findViewById(R.id.goback);

        //return to answers and questions page
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQAlist();
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

    private void openQAlist() {
        Intent in = new Intent(this, questionsAnswers.class);
        startActivity(in);
    }


    //use fun to move on to home page
    public void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }


}
