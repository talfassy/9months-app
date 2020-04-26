package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class main_recommendation_urine extends AppCompatActivity {

    private ImageButton logoButton;
    private EditText testNameInput;
    private ImageButton viewRec;
    private TextView theRec;
    private TextView worngInput_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recommendation_urine);

        logoButton = findViewById(R.id.Image_Logo);
        testNameInput = findViewById(R.id.enterName);
        viewRec = findViewById(R.id.viewrecommendations);
        theRec = findViewById(R.id.recommendations);
        worngInput_text= findViewById(R.id.worngInput);

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });


        final String test_name = testNameInput.getText().toString().trim();



            viewRec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String test_name = testNameInput.getText().toString().trim();
                    provideRecommendations(test_name);

                    if (test_name.equals("")){
                        Toast.makeText(main_recommendation_urine.this , "Please enter the test name", Toast.LENGTH_LONG).show();
                    }

                    if (!(test_name.equals("Nitrite")) && !(test_name.equals("Leucocytes")) && !(test_name.equals("ph")) && !(test_name.equals("Proteine"))
                    && !(test_name.equals("Glucose")) && !(test_name.equals("Ketones")) && !(test_name.equals("UroblinogenPos")) && !(test_name.equals("Bilirubin"))
                    && !(test_name.equals("EryThrocytes"))){
                        theRec.setText("There is no such test in our database and therefore no recommendations are available");

                    }

                    }





            });



        }





    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);

    }


    void provideRecommendations(String name){

        //recommendation for positive NitritePos
        if (name.equals("Nitrite")) {

            theRec.setText("The presence of nitrites and white blood cells in the urine often indicate urinary tract infection.\n" +
                    "The recommendations are:\n" +
                    "1. Drinking water with brewed parsley.\n" +
                    "2. Eating of cranberries without sugar or driniking cranberry juice.\n" +
                    "3. Drinking a spoonful of apple cider vinegar mixed with water.\n" +
                    "4. Taking probiotic pills for women.\n" +
                    "5. In a more serious case requiring antibiotic medication - make an appointment with your doctor and ask for antibiotics to help reduce inflammation.\n");
        }

        //recommendation for positive Leucocytes
        if (name.equals("Leucocytes")) {
            theRec.setText("A high value of white blood cells in the urine may indicate urinary tract infection.\n" +
                    "Recommendations to relieve pain:\n" +
                    "1. Drinking cranberry juice.\n" +
                    "2. Drinking a spoonful of apple cider vinegar mixed with water.\n" +
                    "3. Taking probiotic pills for women.\n" +
                    "Recommendations for treating infection -\n" +
                    "Please make an appointment with your attending physician for a prescription for antibiotics.\n");
        }

        //recommendation for  acidity in urine
        if (name.equals("ph")) {

            theRec.setText("Low level –\n" +
                    "1. If the acidic urine indicates diabetes - make an appointment with the attending physician.\n" +
                    "2. In diarrhea and vomiting condition a lot of water should be consumed.\n" +
                    "If it is a bacterial diarrhea accompanied by dehydration and heat, it is recommended to treat it with antibiotics.\n" +
                    "High level –\n" +
                    "1. If the cause is multiple vomiting - make sure you drink multiple times and ask your doctor for the Pramin medication to help treat nausea without side effects.\n" +
                    "2. If there is a urinary tract infection - please make an appointment with your attending physician for a prescription for antibiotics.\n");
        }


        //recommendation for positive Proteine
        if (name.equals("Proteine")) {

            theRec.setText("An amount of more than 0.3 grams of protein in the urine during 24 hours (together with high blood pressure) usually indicates a condition of preeclampsia - consult the physician urgently and perform additional examinations for the mother and fetus.");
        }

        //recommendation for positive glucose
        if (name.equals("Glucose")) {

            theRec.setText("High blood sugar levels may indicate latent diabetes, so the recommendation is to talk to the attending physician and coordinate sugar loading treatments");
        }

        //recommendation for positive Ketones
        if (name.equals("Ketones")) {
            theRec.setText("A positive result of urinary ketones can indicate: diabetes,\n" +
                    "high body heat, fasting or multiple vomiting during high heat pregnancy.\n" +
                    "1. If you have recently fasted or you have high body heat, these values will most often return to be normal at the next check.\n" +
                    "2. In case of vomiting - it is advised not to consume fried foods and drink a lot. You can also get a prescription for paramine from your doctor.\n" +
                    "3. If you have diabetes - make an appointment with your doctor for appropriate consultation.\n");
        }

        //recommendation for abnormal Uroblinogen
        if (name.equals("UroblinogenPos")) {

            theRec.setText("If the test is different from normal the possible causes are antibiotic consumption or liver disease.\n" +
                    "It is advisable to repeat the urine test to ascertain the cause of the high value and continue monitoring with a female doctor.\n");
        }

        //recommendation for positive Bilirubin
        if (name.equals("Bilirubin")) {
            theRec.setText("The presence of bilirubin in the urine may indicate the development of liver disease and therefore must make an appointment with the attending physician for further consultation.");
        }

        //recommendation for positive EryThrocytes
        if (name.equals("EryThrocytes")) {
            theRec.setText("Higher values than the norm may indicate urinary tract infection, so the recommended treatment is:\n" +
                    "1. Drinking cranberry juice.\n" +
                    "3. Drinking a spoonful of apple cider vinegar mixed with water.\n" +
                    "4. Taking probiotic pills for women.\n" +
                    "5. Please make an appointment with your attending physician for a prescription for antibiotics.\n");
        }



    }
}
