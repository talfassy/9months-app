package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class blood_reccommendation extends AppCompatActivity {

    private TextView titleText;
    private TextView recommendation;
    private ImageButton logoBtn;
    private Button helpBtn;
    private Button not_helpBtn;
    private TextView recommendation2;


    List<String> keyList;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    private ListView list;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_reccommendation);

        //firebase
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();


        list = (ListView) findViewById(R.id.listViewId2);
        titleText = (TextView) findViewById(R.id.checkTestsType);
        recommendation = (TextView) findViewById(R.id.theRecommendation);
        recommendation2 = (TextView) findViewById(R.id.theRecommendation2);
        logoBtn = findViewById(R.id.Image_Logo);
        helpBtn = findViewById(R.id.good);
        not_helpBtn = findViewById(R.id.bad);


        arrayList = new ArrayList<String>();
        keyList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(blood_reccommendation.this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);

        logoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomepage();
            }
        });


        Intent i = getIntent();
        String testType = i.getStringExtra("key");

        //recommendation for low glucose
        if (testType.equals("lowGlucose")) {

            titleText.setText("Low blood sugar: ");
            recommendation.setText("The reasons for low blood sugar in pregnancy are usually eating less than usual, postponing meal time or giving up the meal.\n" +
                    "Therefore, the recommendation is to adhere to an appropriate dietary personalized diet menu that includes three main meals and three intermediate meals to maintain blood sugar levels.");
        }

        //recommendation for high glucose
        if (testType.equals("highGlucose")) {
            titleText.setText("High blood sugar: ");
            recommendation.setText("1. It is recommended carry out sugar loading of 100 grams in fasting , where the glucose value is checked 4 times (in fasting and one hour, two hours and three hours after sugar loading).\n" +
                    "2. Adhere to a low-sugar and carbohydrate diet with personalized dietary advice that includes three main meals and three intermediate meals. It is important to know that there is not one diet that is suitable for everyone.");
        }

        //recommendation for low WBC
        if (testType.equals("lowWBC")) {

            titleText.setText("White blood cell deficiency: ");
            recommendation.setText("Low values indicate viral disease, immune system failure and, in rare cases, cancer.\n" +
                    "There is nothing to worry about, just to schedule an appointment with your family doctor to find out about the existence of a viral illness and taking appropriate medication.");
        }

        //recommendation for high WBC
        if (testType.equals("highWBC")) {
            titleText.setText("High number of white blood cells: ");
            recommendation.setText("1. High values usually indicate the existence of an infection. In other, very rare cases, very high values may indicate blood disease or cancer.\n" +
                    "There is nothing to worry about in most cases this is a simple illness that requires antibiotic treatment, please contact your family doctor for appropriate medication.");
            recommendation2.setText("2. Taking a probiotic supplement");
            helpBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDatabaseReference.child("Recommendations").child("Blood").child("WBC").child("feedback").child("High").child("1").push().setValue("1");
                    openWeigh_rec();
                }
            });

            not_helpBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDatabaseReference.child("Recommendations").child("Blood").child("WBC").child("feedback").child("High").child("2").push().setValue("1");
                    openWeigh_rec2();

                }
            });

            updateRec();
        }



        //recommendation for high RBC
        if (testType.equals("lowRBC")) {

            titleText.setText("Red blood cell deficiency: ");
            recommendation.setText("1. If the anemia occurs following a viral disease - the anemia will pass as soon as the disease passes.\n" +
                    "2. If the anemia appears from iron deficiency - the recommendation is to consume iron-rich products such as red meat, chicken and fish, legumes, fruits, green vegetables and grains. In addition, iron supplements can be consumed when the preference is iron in powder for increasing iron absorption in the body, which significantly reduces the side effects of abdominal pain during pregnancy.\n" +
                    "3. If the anemia appears due to vitamin B12 deficiency - the recommendation is intake of vitamin B12 dietary supplement.\n" +
                    "4. If the anemia  appears following folic acid deficiency - you should consum of folic acid supplement.\n" +
                    "5. If the anemia appears due to kidney insufficiency, the woman condition can usually be improved by administering or injecting erythropoietin - the process requires consultation with a doctor!!");
        }

        //recommendation for high RBC
        if (testType.equals("highRBC")) {
            titleText.setText("High number of red blood cells: ");
            recommendation.setText("It is usually caused by dehydration, the recommendation is to consume a large amount of fluid.");
        }

        //recommendation for low hemoglobin
        if (testType.equals("lowHemoglobin")) {
            titleText.setText("Low hemoglobin: ");
            recommendation.setText("1. Consume a diet rich in iron.\n" +
                    "2. Consumption of iron supplements When preference is iron in powder to increase the absorption of iron in the body, which significantly reduces the side effects of abdominal pain during pregnancy.");
        }

        //recommendation for high hemoglobin
        if (testType.equals("highHemoglobin")) {
            titleText.setText("High hemoglobin: ");
            recommendation.setText("1. Most often is due to fluid shortages so it is recommended to consume lots of fluids.\n" +
                    "2. At extremely high values, it is recommended to meet a hematologist in order to decode and provide appropriate diagnosis.");
        }

        //recommendation for low hematocrit
        if (testType.equals("lowHematocrit")) {
            titleText.setText("Low hematocrit: ");
            recommendation.setText("1. Anemia caused by deficiencies in iron , vitamin B12 and folic acid - appropriate nutritional supplements should be consumed.\n" +
                    "2. Hemoglobin production disorders - lots of fluids need to be consumed.");
        }

        //recommendation for high hematocrit
        if (testType.equals("highHematocrit")) {
            titleText.setText("High hematocrit: ");
            recommendation.setText("High value usually indicates dehydration and / or vomiting and diarrhea. The recommendation is drinking a lot.");
        }

        //recommendation for low MCV
        if (testType.equals("lowMCV")) {
            titleText.setText("Low blood cell volume: ");
            recommendation.setText("1. Low value from the norm can be due at iron deficiency - the recommendation to consum appropriate supplements.\n" +
                    "2. A genetic defect in the production of hemoglobin, as in the case of Thalassemia, in this case, further testing should be performed to rule out Thalassemia - please consult your treating physician.");
        }

        //recommendation for high MCV
        if (testType.equals("highMCV")) {
            titleText.setText("high blood cell volume: ");
            recommendation.setText("Higher values than the norm, coupled with high hemoglobin, are called macrocytic anemia. It is anemia due to deficiency of folic acid or vitamin B12 and therefore its should be consumed as dietary supplements.");
        }

        //recommendation for low MCH
        if (testType.equals("lowMCH")) {
            titleText.setText("The amount and concentration of hemoglobin are low: ");
            recommendation.setText("Low values are very common in pregnant women, which can indicate anemia so supplements like iron, folic acid and b12 should be consumed.");
        }

        //recommendation for high MCH
        if (testType.equals("highMCH")) {
            titleText.setText("The amount and concentration of hemoglobin are high: ");
            recommendation.setText("1. High values characterize, situations in which red blood cells are produced as a result of bone marrow disease - consultation with an appropriate physician is needed.\n" +
                    "2. High values due to physical exertion - a easier trainings should be performed. ");
        }

        //recommendation for low MCHC
        if (testType.equals("lowMCHC")) {
            titleText.setText("The amount and concentration of hemoglobin are low: ");
            recommendation.setText("Low values are very common in pregnant women, which can indicate anemia so supplements like iron, folic acid and b12 should be consumed.");
        }

        //recommendation for high MCHC
        if (testType.equals("highMCHC")) {
            titleText.setText("The amount and concentration of hemoglobin are high: ");
            recommendation.setText("1. High values characterize, situations in which red blood cells are produced as a result of bone marrow disease - consultation with an appropriate physician is needed.\n" +
                    "2. High values due to physical exertion - a easier trainings should be performed. ");
        }

        //recommendation for low RDW
        if (testType.equals("lowRDW")) {
            titleText.setText("The recommendation for variance of red blood cell volume is: ");
            recommendation.setText(" differences in the blood spherical diameter is the first thing that comes with anemia due to iron deficiency - so the recommendation is to consume an iron supplement.");
        }

        //recommendation for high RDW
        if (testType.equals("highRDW")) {
            titleText.setText("The recommendation for variance of red blood cell volume is: ");
            recommendation.setText(" differences in the blood spherical diameter is the first thing that comes with anemia due to iron deficiency - so the recommendation is to consume an iron supplement.");
        }

        //recommendation for low Platelets
        if (testType.equals("lowPlatelets")) {
            titleText.setText("Low platelet count: ");
            recommendation.setText("Decreased platelet may be associated with preeclampsia and so it is necessary to schedule an appointment with the attending physician.");
        }

        //recommendation for high Platelets
        if (testType.equals("highPlatelets")) {
            titleText.setText("High platelet count: ");
            recommendation.setText("The causes can be iron deficiency, bleeding, infectious disease, connective tissue disease, and tumors. The recommendation is to consume iron supplements and make an appointment with the attending physician.");
        }

        //recommendation for low MPV
        if (testType.equals("lowMPV")) {
            titleText.setText("Low average blood platelet volume: ");
            recommendation.setText("In most cases, deviation in the values of this test does not indicate a problem, so there is no cause for concern.");
        }

        //recommendation for high MPV
        if (testType.equals("highMPV")) {
            titleText.setText("High average blood platelet volume: ");
            recommendation.setText("High value indicates young platelet production in bone marrow due to platelet destruction.");
        }


    }

    //open update recommendations weight - positive feedback
    private void openWeigh_rec() {

        Intent in = new Intent(this, recommendations_weight.class);
        in.putExtra("key", "highWBC");
        startActivity(in);


    }

    //open update recommendations weight - negative feedback
    private void openWeigh_rec2() {

        Intent in = new Intent(this, recommendation_wight_sub.class);
        in.putExtra("key", "highWBC");
        startActivity(in);

    }

    private void openHomepage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }

//check if recommendations weight is 0 => if it does the recommendation not available
    private void updateRec() {

        mDatabaseReference.child("Recommendations").child("Blood").child("WBC").child("Weight").child("High").child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userId = dataSnapshot.getValue(String.class);
                if ( userId.equals("0")) {
                    recommendation.setText("");
                    recommendation2.setText("Taking a probiotic supplement");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}