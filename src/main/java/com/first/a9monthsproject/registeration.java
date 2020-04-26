package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registeration extends AppCompatActivity {

    private Button createButton;
    private ImageButton returnButton;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText weeks;
    private EditText password1;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mAuth;
    private ProgressBar mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        //handle the editText and Buttons
        {
            firstName = (EditText) findViewById(R.id.enterFirstName);
            lastName = (EditText) findViewById(R.id.enterLastName);
            email = (EditText) findViewById(R.id.enterEmail);
            weeks = (EditText) findViewById(R.id.enterweek);
            password1 = (EditText) findViewById(R.id.enterPass);
            returnButton = (ImageButton) findViewById(R.id.go_back);
            createButton = (Button) findViewById(R.id.createAccount);
        }

        //handle the return Button
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainPage();
            }
        });

        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference().child("MUsers");
        mAuth = FirebaseAuth.getInstance();
        mProgressDialog = new ProgressBar(this);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount();
            }
        });


    }

    private void createNewAccount() {

        final String fname = firstName.getText().toString().trim();
        final String lname = lastName.getText().toString().trim();
        final String tmpEmail = email.getText().toString().trim();
        final String tmpWeeks = weeks.getText().toString().trim();
        final String pass1 = password1.getText().toString().trim();


        if(!TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lname)&& !TextUtils.isEmpty(tmpEmail)
                && !TextUtils.isEmpty(tmpWeeks) && !TextUtils.isEmpty(pass1)){

            Toast.makeText(registeration.this ,"creating account", Toast.LENGTH_LONG).show();
            mProgressDialog.isShown();

            mAuth.createUserWithEmailAndPassword(tmpEmail, pass1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    if (authResult != null) {
                        String userId = mAuth.getCurrentUser().getUid();
                        // when we create a user we create a user id that we can add information to this user
                        DatabaseReference currentUserDB = mDatabaseReference.child(userId);
                        currentUserDB.child("First_name").setValue(fname);
                        currentUserDB.child("Last_name").setValue(lname);
                        currentUserDB.child("Email").setValue(tmpEmail);
                        currentUserDB.child("Pregnancy_week").setValue(tmpWeeks);
                        currentUserDB.child("Password").setValue(pass1);
                        currentUserDB.child("Image").setValue("none");
                        currentUserDB.child("Tests_List").setValue("none");

                        openHomePage();


                    }

                }

            });
        }}


    // use the fun to move on to home page
    public void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }

    public void openMainPage() {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }


}
