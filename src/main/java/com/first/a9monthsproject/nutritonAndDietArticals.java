package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class nutritonAndDietArticals extends AppCompatActivity {

    private Button artical1;
    private Button artical2;
    private Button artical3;
    private Button artical4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutriton_and_diet_articals);

        artical1= (Button)findViewById(R.id.Weight_gain);
        artical2= (Button)findViewById(R.id.Components);
        artical3= (Button)findViewById(R.id.Nutritional_supplements);
        artical4= (Button)findViewById(R.id.Damagingfoods);



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
        Intent in = new Intent(this, nutritaionArtical1.class);
        startActivity(in);
    }

    //use fun to move on to artical_2 page
    public void openArtical_2() {
        Intent in = new Intent(this, nutritaion_artical2.class);
        startActivity(in);
    }

    //use fun to move on to artical_3 page
    public void openArtical_3() {
        Intent in = new Intent(this, nutritaion_artical3.class);
        startActivity(in);
    }

    //use fun to move on to artical_4 page
    public void openArtical_4() {
        Intent in = new Intent(this, nurtiationArtical4.class);
        startActivity(in);
    }


}
