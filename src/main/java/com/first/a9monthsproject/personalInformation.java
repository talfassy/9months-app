package com.first.a9monthsproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class personalInformation extends AppCompatActivity {

    private TextView first_name;
    private TextView last_name;
    private TextView date_info;
    private TextView email_ad;
    private TextView password_info;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);

        first_name = (TextView) findViewById(R.id.inputFirstName);
        last_name = (TextView) findViewById(R.id.inputLastName);
        date_info = (TextView) findViewById(R.id.inputweek);
        email_ad = (TextView) findViewById(R.id.inputEmail);
        password_info = (TextView) findViewById(R.id.inputPass);

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userKey = user.getUid();

        //get the first name from the database
        mDatabaseReference.child("MUsers").child(userKey).child("First_name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userId = dataSnapshot.getValue(String.class);
                first_name.setText(userId);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        //get the last name from the database
        mDatabaseReference.child("MUsers").child(userKey).child("Last_name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userId = dataSnapshot.getValue(String.class);
                last_name.setText(userId);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //get the first menstrual date from the database
        mDatabaseReference.child("MUsers").child(userKey).child("Pregnancy_week").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userId = dataSnapshot.getValue(String.class);
                date_info.setText(userId);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //get the email from the database
        mDatabaseReference.child("MUsers").child(userKey).child("Email").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userId = dataSnapshot.getValue(String.class);
                email_ad.setText(userId);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //get the password from the database
        mDatabaseReference.child("MUsers").child(userKey).child("Password").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userId = dataSnapshot.getValue(String.class);
                password_info.setText(userId);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
