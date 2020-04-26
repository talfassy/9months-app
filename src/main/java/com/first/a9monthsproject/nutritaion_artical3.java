package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class nutritaion_artical3 extends AppCompatActivity {

    private Button returnButton;
    private Button returnMainArtical;
    private ImageButton logoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritaion_artical3);

        returnButton = (Button) findViewById(R.id.testList);
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
                openNutritonArticalPage();
            }
        });

        returnMainArtical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainArticlesPage();
            }
        });
    }
        //use fun to move on to nutriton And Diet Articals page
        public void openNutritonArticalPage() {
            Intent in = new Intent(this, nutritonAndDietArticals.class);
            startActivity(in);

        }


        //use fun to move on to main Articals page
        public void openMainArticlesPage() {
            Intent in = new Intent(this, articles.class);
            startActivity(in);

        }

         //move to home page
         private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }
}



