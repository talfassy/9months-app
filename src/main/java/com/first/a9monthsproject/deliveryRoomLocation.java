package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class deliveryRoomLocation extends AppCompatActivity {

    private Button northeButton;
    private Button centralButton;
    private Button jerusalemButton;
    private Button southernButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_room_location);

        northeButton= (Button) findViewById(R.id.northe);
        centralButton= (Button) findViewById(R.id.central);
        jerusalemButton= (Button) findViewById(R.id.jerusalem);
        southernButton= (Button) findViewById(R.id.Southern);
        
        northeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNorthActivity();
            }
        });

        centralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCenterActivity();
            }
        });

        jerusalemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJerusalemActivity();
            }
        });

        southernButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSouthActivity();
            }
        });
    }

    private void openSouthActivity() {
        Intent in = new Intent(this , South.class);
        startActivity(in);
    }

    private void openJerusalemActivity() {
        Intent in = new Intent(this , jerusalem.class);
        startActivity(in);
    }

    private void openCenterActivity() {
        Intent in = new Intent(this , center.class);
        startActivity(in);
    }

    private void openNorthActivity() {
        Intent in = new Intent(this, northe.class);
        startActivity(in);
    }
}
