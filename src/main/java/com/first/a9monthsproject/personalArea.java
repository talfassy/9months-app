package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class personalArea extends AppCompatActivity {

    private Button presonalButton;

    private Button fetusSize;
    private Button picButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_area);

        presonalButton = (Button) findViewById(R.id.WatchPersonalInfo);
        picButton = (Button) findViewById(R.id.photoAlbum);
        fetusSize =(Button) findViewById(R.id.fruitSize);

        presonalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPersonalInfoPage();
            }
        });

        picButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlbumPage();
            }
        });

        fetusSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBabySizePage();
            }
        });


    }

    private void openPersonalInfoPage() {

        Intent in = new Intent(this, personalInformation.class);
        startActivity(in);
    }

    private void openBabySizePage() {
        Intent in = new Intent(this, babySizeFruit.class);
        startActivity(in);
    }

    private void openAlbumPage() {
        Intent in = new Intent(this, hoosingOptionImageAlbum.class);
        startActivity(in);
    }



}
