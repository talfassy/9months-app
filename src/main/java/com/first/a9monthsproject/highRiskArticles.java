package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class highRiskArticles extends AppCompatActivity {
    private Button artical1;
    private Button artical2;
    private Button artical3;
    private Button artical4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_risk_articles);

        artical1= (Button)findViewById(R.id.generalInfo);
        artical2= (Button)findViewById(R.id.preeclampsia);
        artical3= (Button)findViewById(R.id.diabetes);
        artical4= (Button)findViewById(R.id.gbs);



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

        artical4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArtical_4();
            }
        });


    }


    //use fun to move on to artical_1 page
    public void openArtical_1() {
        Intent in = new Intent(this, highRiskArticle1.class);
        startActivity(in);
    }

    //use fun to move on to artical_2 page
    public void openArtical_2() {
        Intent in = new Intent(this, highRiskArticle2.class);
        startActivity(in);
    }

    //use fun to move on to artical_3 page
    public void openArtical_3() {
        Intent in = new Intent(this, highRiskArticle3.class);
        startActivity(in);
    }

    //use fun to move on to artical_4 page
    public void openArtical_4() {
        Intent in = new Intent(this, highRiskArticle4.class);
        startActivity(in);
    }


    //use fun to move on to articles page
    public void openArticalsPage() {
        Intent in = new Intent(this, articles.class);
        startActivity(in);
    }
}

