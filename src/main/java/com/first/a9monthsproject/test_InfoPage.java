package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class test_InfoPage extends AppCompatActivity {

    private Button preButton;
    private Button firstBuuton;
    private Button secondBuuton;
    private Button thirdBuuton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__info_page);

        preButton =(Button) findViewById(R.id.prePregnancy);
        firstBuuton =(Button) findViewById(R.id.firsttrimester);
        secondBuuton =(Button) findViewById(R.id.sectrimester);
        thirdBuuton =(Button) findViewById(R.id.thiredtrimester);


        //move to tests list - pre pregnancy
        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrePregnancyPage();
            }
        });

        //move to tests list - first trimester
        firstBuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfFirstTrimsterPage();

            }
        });

        //move to tests list - sec trimester
        secondBuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfSecTrimsterPage();
            }
        });

        //move to tests list - third trimester
        thirdBuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfThirdTrimsterPage();
            }
        });

 
    }

    //use fun to move on to pre pregnancy tests page
    public void openPrePregnancyPage() {
        Intent in = new Intent(this, prePregnancyTests.class);
        startActivity(in);
    }

    //use fun to move on to first trimester tests page
    public void openfFirstTrimsterPage() {
        Intent in = new Intent(this, firstTrimester.class);
        startActivity(in);
    }

    //use fun to move on to second trimester tests page
    public void openfSecTrimsterPage() {
        Intent in = new Intent(this, secTrimsterTests.class);
        startActivity(in);
    }

    //use fun to move on to third trimester tests page
    public void openfThirdTrimsterPage() {
        Intent in = new Intent(this, triedTrimesterTests.class);
        startActivity(in);
    }

    //use fun to move on to home page
    public void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }
}
