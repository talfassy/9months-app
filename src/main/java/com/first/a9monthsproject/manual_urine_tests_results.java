package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class manual_urine_tests_results extends AppCompatActivity {

    private EditText inputNitrite;
    private EditText inputLeucocytes;
    private EditText inputPh;
    private EditText inputProteineUR;
    private EditText inputGlucose;
    private EditText inputKeytones;
    private EditText inputUroblinogen;
    private EditText inputBilirubin;
    private EditText inputEryThrocytes;

    private ImageButton logoButton;
    private Button addButton;
    private Button decoding;

    private TextView checkString;


    String tests_results = "  Nitrite Leucocytes PH ProteineUR Glucose Keytones Uroblinogen Bilirubin EryThrocytes";

    private ArrayList<String> arrayListString;
    private long mLastClickTime = 0;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_urine_tests_results);

        checkString = findViewById(R.id.check);
        addButton = findViewById(R.id.addResults);
        decoding =findViewById(R.id.decodingResults);
        logoButton = findViewById(R.id.Image_Logo);

        inputNitrite = findViewById(R.id.inputNitrite);
        inputLeucocytes = findViewById(R.id.inputLeucocytes);
        inputPh = findViewById(R.id.inputPh);
        inputProteineUR = findViewById(R.id.inputProteineUR);
        inputGlucose = findViewById(R.id.inputGlucose);
        inputKeytones = findViewById(R.id.inputKeytones);
        inputUroblinogen = findViewById(R.id.inputUroblinogen);
        inputBilirubin =findViewById(R.id.inputBilirubin);
        inputEryThrocytes = findViewById(R.id.inputEryThrocytes);

        //firebase
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SystemClock.elapsedRealtime() - mLastClickTime < 10000) {
                    return;
                }
                else {
                    mLastClickTime = SystemClock.elapsedRealtime();

                    addTestResult();
                }


            }
        });

        decoding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDecoding_urine_tests();
            }
        });
    }

    private void openDecoding_urine_tests() {
        Intent in = new Intent(this, decodingResults_urine.class);
        startActivity(in);

    }

    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);

    }


    //Gets the information from the user and creates a string of the results of that test
    private void addTestResult() {

        final FirebaseUser user = mAuth.getCurrentUser();


        final String nitrite = inputNitrite.getText().toString().trim();
        final String leucocytes = inputLeucocytes.getText().toString().trim();
        final String ph = inputPh.getText().toString().trim();
        final String protein = inputProteineUR.getText().toString().trim();
        final String glu = inputGlucose.getText().toString().trim();
        final String keytones = inputKeytones.getText().toString().trim();
        final String uroblinogen = inputUroblinogen.getText().toString().trim();
        final String bilirubin = inputBilirubin.getText().toString().trim();
        final String erThrocytes = inputEryThrocytes.getText().toString().trim();


        if (!TextUtils.isEmpty(glu) && !TextUtils.isEmpty(nitrite) && !TextUtils.isEmpty(leucocytes)
                && !TextUtils.isEmpty(ph) && !TextUtils.isEmpty(protein) && !TextUtils.isEmpty(keytones) &&
                !TextUtils.isEmpty(uroblinogen) && !TextUtils.isEmpty(bilirubin) && !TextUtils.isEmpty(erThrocytes) ) {

            final String val = tests_results + " " + nitrite + " " + leucocytes + " " + ph + " " + protein + " " + glu
                    + " " + keytones + " " + uroblinogen + " " + bilirubin + " " + erThrocytes ;
            checkString.setText(val);

            String[] result = val.split(" , \\s*,\\s*");
            for (String a : result) {

                //adding the values ​​we read into firebase
                databaseReference.child("MUsers").child(user.getUid()).child("Tests_result_urine").push().setValue(a);

            }//end loop on result



        } else {
            checkString.setText("One or more missing values, please fill in again");

        }


    }
}
