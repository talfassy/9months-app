package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class sportsArticles extends AppCompatActivity {

    private Button artical1;
    private Button artical2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_articles);

        artical1= (Button)findViewById(R.id.Benefits);
        artical2= (Button)findViewById(R.id.Rules);


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


    }

    //use fun to move on to artical_1 page
    public void openArtical_1() {
        Intent in = new Intent(this, sportArtical1.class);
        startActivity(in);
    }

    //use fun to move on to artical_2 page
    public void openArtical_2() {
        Intent in = new Intent(this, sportArticle2.class);
        startActivity(in);
    }


}



