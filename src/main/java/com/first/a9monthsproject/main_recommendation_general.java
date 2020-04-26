package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class main_recommendation_general extends AppCompatActivity {

    private Button firstTrim;
    private Button secondTrim;
    private Button thirdTrim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recommendation_general);

        firstTrim= (Button)findViewById(R.id.first);
        secondTrim=(Button)findViewById(R.id.second);
        thirdTrim=(Button)findViewById(R.id.third);

        firstTrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirstTrimPage();
            }
        });

        secondTrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondTrimPage();
            }
        });

        thirdTrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openThirdTrimPage();
            }
        });
    }

    private void openFirstTrimPage() {
        Intent in = new Intent( this,first_trim_recommendation.class);
        startActivity(in);
    }
    private void openSecondTrimPage() {
        Intent in = new Intent( this,second_trim_recommendation.class);
        startActivity(in);
    }
    private void openThirdTrimPage() {
        Intent in = new Intent( this,third_trim_recommendation.class);
        startActivity(in);
    }
}
