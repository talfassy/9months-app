package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class articles extends AppCompatActivity {

    private Button nutritionButton;
    private Button sportButton;
    private Button vaccinationsButton;
    private Button riskButton;
    private Button avoidButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        nutritionButton = (Button) findViewById(R.id.nutrition);
        sportButton = (Button) findViewById(R.id.sport);
        avoidButton = (Button) findViewById(R.id.avoid);
        vaccinationsButton = (Button) findViewById(R.id.vaccinations);
        riskButton = (Button) findViewById(R.id.risk);


        // handle the nutrition Button - move to nutrition articles
        nutritionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNutritionDietArticles();
            }
        });

        // handle the sport Button - move to sport articles
        sportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSportArticle();
            }
        });

        // handle the vaccinations Button - move to vaccinations articles
        vaccinationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVaccinationsArticles();
            }
        });

        // handle the return Button - move to home page
        riskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRiskArticle();
            }
        });


        // handle the nutrition Button - move to tings to avoid articles
        avoidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThingsToAvoid();
            }
        });

    }


    //use fun to move on to notrition articles page
    public void openNutritionDietArticles() {
        Intent in = new Intent(this, nutritonAndDietArticals.class);
        startActivity(in);
    }

    //use fun to move on to vaccinations articles page
    public void openSportArticle() {
        Intent in = new Intent(this, sportsArticles .class);
        startActivity(in);
    }

    //use fun to move on to sport articles page
    public void openSportArticles() {
        Intent in = new Intent(this, sportsArticles.class);
        startActivity(in);
    }

    //use fun to move on to home page
    public void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }

    //use fun to move on to vaccinations articles page
    public void openVaccinationsArticles() {
        Intent in = new Intent(this, vaccinationsArticles.class);
        startActivity(in);
    }

    //use fun to move on to high risk pregnancy articles page
    public void openRiskArticle() {
        Intent in = new Intent(this, highRiskArticles .class);
        startActivity(in);
    }

    //use fun to move on to things to avoid articles page
    public void openThingsToAvoid() {
        Intent in = new Intent(this, thingsToAvoidArticles .class);
        startActivity(in);
    }
}
