package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class questionsAnswers extends AppCompatActivity {

    private Button nutritionButton;
    private Button VaccimationButton;
    private Button breastButton;
    private Button rightsButton;
    private Button birthButton;
    private Button babyAndAfterButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_answers);

        nutritionButton =(Button) findViewById(R.id.nutrition);
        VaccimationButton=(Button) findViewById(R.id.VaccinesAndTests);
        rightsButton = (Button) findViewById(R.id.Pregnantrights);
        birthButton =(Button) findViewById(R.id.birth);
        babyAndAfterButton =(Button) findViewById(R.id.afterBirth);
        breastButton = (Button) findViewById(R.id.breastFeeding);




        //handle nutrition button -> move to nutrition and sport QA
        nutritionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNutriationQA();
            }
        });

        ////handle nutrition button -> move to vaciomation QA
        VaccimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVaccineAndTestQAPage();
            }
        });

        //handle breast button -> move to breastfeeding QA
        breastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBreastfeddingQA();
            }
        });

        // move to after birth QA page
        babyAndAfterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAfterBirthPage();
            }
        });

        // move to birth QA page
        birthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBirthQA();
            }
        });

        // move to rights QA page
        rightsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPregnantRightsPage();
            }
        });




    }

    //move to after birth QA page
    private void openAfterBirthPage() {
        Intent in = new Intent(this, afterBirthQA.class);
        startActivity(in);
    }

    //use fun to move on to birth QA page
    private void openBirthQA() {
        Intent in = new Intent(this, birthQA.class);
        startActivity(in);
    }

    //use fun to move to nutrition and sport QA page
    public void openNutriationQA() {
        Intent in = new Intent(this, notritonAndSportQA.class);
        startActivity(in);
    }

    //use fun to move to breastfeeding QA page
    public void openBreastfeddingQA() {
        Intent in = new Intent(this, breastfeeding_qa.class);
        startActivity(in);
    }

    //use fun to move to pregnant_rights QA page
    public void openPregnantRightsPage() {
        Intent in = new Intent(this, pregnant_rightsQa.class);
        startActivity(in);
    }

    //use fun to move to vaccines and tests QA page
    public void openVaccineAndTestQAPage() {
        Intent in = new Intent(this, vaccineAndTestingQA.class);
        startActivity(in);
    }

    //use fun to move on to home page
    public void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }


}


