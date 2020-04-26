package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class highRiskArticle1 extends AppCompatActivity {
    private Button returnButton;
    private Button returnMainArtical;
    private ImageButton logoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_risk_article1);

        returnButton =(Button) findViewById(R.id.testList);
        returnMainArtical = (Button) findViewById(R.id.returnMainArticles);
        logoButton = (ImageButton) findViewById(R.id.Image_Logo);

        //move to home page when we push on logo
        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHighRiskPage();
            }
        });

        returnMainArtical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainArticlesPage();
            }
        });
    }

    //use fun to move on to high risk pregnancy page
    public void openHighRiskPage() {
        Intent in = new Intent(this, highRiskArticles.class);
        startActivity(in);
    }

    //move to home page
    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }


    //use fun to move on to main Articals page
    public void openMainArticlesPage() {
        Intent in = new Intent(this, articles.class);
        startActivity(in);

    }
}
