package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class main_recommendation_blood extends AppCompatActivity {

    private ImageButton logoButton;
    private EditText testNameInput;
    private ImageButton viewRec;
    private TextView theRec;
    private TextView worngInput_text;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recommendation_blood);

        //firebase
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();


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





        viewRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String test_name = testNameInput.getText().toString().trim();
                provideRecommendations(test_name);

                if (test_name.equals("")){
                    Toast.makeText(main_recommendation_blood.this , "Please enter the test name", Toast.LENGTH_LONG).show();
                }

                if (!(test_name.equals("Glucose")) && !(test_name.equals("WBC")) && !(test_name.equals("RBC")) && !(test_name.equals("Hemoglobin"))
                        && !(test_name.equals("MCV")) && !(test_name.equals("MCH")) && !(test_name.equals("MCHC")) && !(test_name.equals("RDW"))
                        && !(test_name.equals("Platelets")) && !(test_name.equals("MPV"))&& !(test_name.equals("Hematocrit"))){
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

        //recommendation for Glucose in the blood
        if (name.equals("Glucose")) {

            theRec.setText("High level of sugar -\n" +
                    "1. Sugar loading is recommended where the glucose value is checked 4 times.\n" +
                    "2. Adhere to a low-sugar and carbohydrate diet with personalized dietary advice that includes three main meals and three intermediate meals. \n" +
                    "Low level of sugar -\n" +
                    "The recommendation is to adhere to an appropriate dietary personalized diet menu that includes three main meals and three intermediate meals to maintain blood sugar levels.");
        }

        //recommendation for white cells blood in the blood
        if (name.equals("WBC")) {
            theRec.setText("High level of white blood cells -\n" +
                    "usually indicate the existence of an infection. There is nothing to worry about in most cases this is a simple illness that requires antibiotic treatment, please contact your family doctor for appropriate medication.\n" +
                    "Low level of white blood cells -\n" +
                    "Low values indicate viral disease, immune system failure and, in rare cases, cancer. \n"+
                    "There is nothing to worry about, make appointment with your family doctor to find out about the existence of a viral illness and taking appropriate medication. ");
        }

        //recommendation for  low red cells blood in the blood
        if (name.equals("RBC")) {

            theRec.setText("Low level of red blood cells –\n" +
                    "When the red spheres count is low for some reason, such a condition is of bloodlessness and is called: anemia.-\n"+
                    "1. If the anemia occurs following a transient condition, such as a viral disease - the anemia will pass as soon as the disease passes.\n" +
                    "2. If the anemia occurs following from iron deficiency - it is possible to consume iron-rich products such as red meat, chicken and fish, legumes, fruits, green vegetables and grains. In addition, iron supplements can be consumed when the preference is iron in powder for increasing iron absorption in the body, which significantly reduces the side effects of abdominal pain during pregnancy.\n" +
                    "3. If the anemia appears due to vitamin B12 deficiency - intake of vitamin B12 dietary supplement.\n" +
                    "4. If the anemia appears due folate deficiency - consumption of folic acid supplement.\n"+
                    "5. If the woman suffers from kidney failure, her condition can usually be improved by administering or injecting erythropoietin - requires consultation with a doctor!\n");
        }


        //recommendation for low or hight levels of hemoglobin
        if (name.equals("Hemoglobin")) {

            theRec.setText("High level of Hemoglobin -\n" +
                    "1. Need to consume an iron-rich diet.\n" +
                    "2. Consumption of iron supplements when preference is iron in powder to increase iron absorption in the body, which significantly reduces the side effects of abdominal pain during pregnancy. \n" +
                    "Low level of sugar -\n" +
                    "This is usually due to a lack of fluids, so it is recommended to consume lots of fluids.\n" +
                    "In addition, at extremely high values, it is recommended to meet with hematologist in order to decode and provide an appropriate diagnosis.");
        }

        //recommendation for hogh and low levels of Hematocrit in the blood
        if (name.equals("Hematocrit")) {

            theRec.setText("High level of Hematocrit- -\n" +
                    "High value usually indicates dehydration and / or vomiting and diarrhea. The recommendation is a lot of drinking.\n" +
                    "Low level of Hematocrit -\n" +
                    "Low value may be in the following situations:-\n" +
                    "1. Anemia caused by iron deficiencies, vitamin B12, folic acid - appropriate nutritional supplements should be consumed.\n"+
                    "1. Hemoglobin production disorders - lots of fluids need to be consumed.");
        }

        //recommendation for high and low levels of MCV in the blood
        if (name.equals("MCV")) {
            theRec.setText("High level of Mean Corpuscular Volume-\n" +
                    "A higher values than the norm, coupled with high hemoglobin, are called macrocytic anemia. It is anemia due to deficiency in folic acid or vitamin B12 and therefore should be consumed as dietary supplements.\n" +
                    "Low level of Mean Corpuscular Volume-\n" +
                    "A lower value than the norm can target iron deficiency - the need for supplements is needed. \n"+
                    "Another reason is a genetic defect in the production of hemoglobin, as in the case of thalassemia, in this case, you need to make an appointment with a doctor for further consultation.");
        }

        //recommendation for high or low values og MCH or MCHC in the blood
        if (name.equals("MCH") || name.equals("MCHC")) {

            theRec.setText("High values-\n" +
                    "High values usually represent conditions in which increased production of red blood cells is due to bone marrow disease - consultation with an appropriate physician is needed.\n" +
                    "High values due physical exertion - Training intensity and number of workouts should be reduced per week.\n" +
                    "Low values-\n" +
                    "Very common in pregnant women, anemia can be indicated and therefore supplements such as iron, folic acid and b12 should be consumed.\n");
        }

        //recommendation for RWD in the blood
        if (name.equals("RWD")) {
            theRec.setText("The different sphericals diameter is the first thing that comes with anemia caused by iron deficiency - which is why an iron supplement should be consumed.");
        }

        //recommendation for high and low values of Platelets in the blood
        if (name.equals("Platelets")) {
            theRec.setText("Highe values of Platelets -\n" +
                    "The causes of which can be iron deficiency, bleeding, infectious disease and tumors. Iron supplements should be consumed and an appointment should be made to the attending physician.\n" +
                    "Low values of Platelets -.\n" +
                    "A slight decrease in platelets is insignificant.\n" +
                    "Extreme decreased platelet count may be associated with preeclampsia so it is necessary to schedule an appointment with the attending physician.\n");
        }

        //recommendation for MPV  in the blood
        if (name.equals("MPV")) {
            theRec.setText("In most cases, deviation in the values of this test does not indicate a problem.");
        }

    }
}


