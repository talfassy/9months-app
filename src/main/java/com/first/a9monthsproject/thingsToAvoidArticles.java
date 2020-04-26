package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class thingsToAvoidArticles extends AppCompatActivity {

    private Button artical1;
    private Button artical2;
    private Button artical3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_to_avoid_articles);

        artical1 = (Button) findViewById(R.id.alcohol);
        artical2 = (Button) findViewById(R.id.smoking);
        artical3 = (Button) findViewById(R.id.drugs);





        artical1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArtical_1();
            }
        });

        artical2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArtical_2();
            }
        });

        artical3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArtical_3();
            }
        });


    }




    //use fun to move on to artical_1 page
    public void openArtical_1() {
        Intent in = new Intent(this, thingsToAvoidArticle1.class);
        startActivity(in);
    }

    //use fun to move on to artical_2 page
    public void openArtical_2() {
        Intent in = new Intent(this, thingsToAvoidArticle2.class);
        startActivity(in);
    }

    //use fun to move on to artical_3 page
    public void openArtical_3() {
        Intent in = new Intent(this, thingsToAvoidArticle3.class);
        startActivity(in);
    }
}