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

public class Manual_blood_tests_result extends AppCompatActivity {

    private ImageButton logoButton;
    private EditText inputGlucose;
    private EditText inputWBC;
    private EditText inputRBC;
    private EditText inputHemoglobin;
    private EditText inputHematocrit;
    private EditText inputMCV;
    private EditText inputMCH;
    private EditText inputMCHC;
    private EditText inputRDW;
    private EditText inputPlayelets;
    private EditText inputMPV;

    private Button addButton;
    private Button decoding;

    private TextView checkString;

    String tests_results = "  Glucose WBC RBC Hemoglobin Hematocrit MCV MCH MCHC RDW Platelets MPV";

    private ArrayList<String> arrayListString;


    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;


    private long mLastClickTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_blood_tests_result);

        logoButton = findViewById(R.id.Image_Logo);
        checkString = findViewById(R.id.check);
        addButton = findViewById(R.id.addResults);
        decoding =findViewById(R.id.decodingResults);

        inputGlucose = findViewById(R.id.inputGlucose);
        inputWBC = findViewById(R.id.m_WBC_input);
        inputRBC = findViewById(R.id.m_RBC_input);
        inputHemoglobin = findViewById(R.id.m_hemoglobin_input);
        inputHematocrit = findViewById(R.id.m_hematocrit_input);
        inputMCV = findViewById(R.id.m_MCV_input);
        inputMCH = findViewById(R.id.m_MCH_input);
        inputMCHC = findViewById(R.id.m_MCHC_input);
        inputRDW = findViewById(R.id.m_RDW_input);
        inputPlayelets = findViewById(R.id.m_platelets_input);
        inputMPV = findViewById(R.id.m_MPV_input);


        //arrays
        arrayListString = new ArrayList<String>();

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
                openDecodingPage();
            }
        });


    }

    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);

    }

    //Gets the information from the user and creates a string of the results of that test
    private void addTestResult() {

        final FirebaseUser user = mAuth.getCurrentUser();

        final String glu = inputGlucose.getText().toString().trim();
        final String wbc = inputWBC.getText().toString().trim();
        final String rbc = inputRBC.getText().toString().trim();
        final String hemoglobin = inputHemoglobin.getText().toString().trim();
        final String hematocrit = inputHematocrit.getText().toString().trim();
        final String mcv = inputMCV.getText().toString().trim();
        final String mch = inputMCH.getText().toString().trim();
        final String mchc = inputMCHC.getText().toString().trim();
        final String rdw = inputRDW.getText().toString().trim();
        final String platelets = inputPlayelets.getText().toString().trim();
        final String mpv = inputMPV.getText().toString().trim();

        if (!TextUtils.isEmpty(glu) && !TextUtils.isEmpty(wbc) && !TextUtils.isEmpty(rbc)
                && !TextUtils.isEmpty(hemoglobin) && !TextUtils.isEmpty(hematocrit) && !TextUtils.isEmpty(mcv) &&
                !TextUtils.isEmpty(mch) && !TextUtils.isEmpty(mch) && !TextUtils.isEmpty(mchc) && !TextUtils.isEmpty(rdw)
                && !TextUtils.isEmpty(platelets) && !TextUtils.isEmpty(mpv)) {

            final String val = tests_results + " " + glu + " " + wbc + " " + rbc + " " + hemoglobin + " " + hematocrit
                    + " " + mcv + " " + mch + " " + mchc + " " + rdw + " " + platelets + " " + mpv;
            checkString.setText(val);

            String[] result = val.split(" , \\s*,\\s*");
            for (String a : result) {

                //adding the values ​​we read into firebase
                databaseReference.child("MUsers").child(user.getUid()).child("Tests_result_blood").push().setValue(a);

            }//end loop on result



        } else {
            checkString.setText("One or more missing values, please fill in again");

        }


    }

    private void openDecodingPage() {
        Intent in = new Intent(this, decodingResults.class);
        startActivity(in);
    }

}


