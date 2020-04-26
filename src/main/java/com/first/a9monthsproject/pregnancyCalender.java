package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class pregnancyCalender extends AppCompatActivity {

    private Calendar myCalendar;
    private TextView weekinfo;
    private DatabaseReference myRef;
    private FirebaseDatabase dataBase;
    private String value;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDb;
    private static final String TAG = "MainActivity";
    public String userId;
    public Date lastMenstrualDate;
    public Date currentTime;
    private ImageButton logoButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy_calender);

        logoButton= findViewById(R.id.Image_Logo);

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mDb = mDatabase.getReference();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userKey = user.getUid();

        mDb.child("MUsers").child(userKey).child("Pregnancy_week").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userId = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Date: " + userId);
               // Toast.makeText(pregnancyCalender.this, "week " + userId , Toast.LENGTH_LONG).show();
                weekinfo=(TextView)findViewById(R.id.Informationaboutweeks);
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    lastMenstrualDate = sdf.parse(userId);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                currentTime = Calendar.getInstance().getTime();

                long diff = currentTime.getTime() - lastMenstrualDate.getTime();
                long seconds = diff / 1000;
                long minutes = seconds / 60;
                long hours = minutes / 60;
                long days = (hours / 24) ;
                System.out.println (userId);

                System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

                int weeks= (int) (days/7.0);
                int day= (int) (days%7.0);

                weekinfo.setText("Congragulations!! You are at week number "+weeks+ ", day " + day);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });


        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

















/*
// Read from the database
        dataBase=FirebaseDatabase.getInstance();
        myRef=dataBase.getReference("MUser");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                 value = dataSnapshot.getValue(String.class);
                Log.d("message", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("message", "Failed to read value.", error.toException());
            }
        });


*/




        String data = userId;
     //   Toast.makeText(pregnancyCalender.this, "week" + weeks + " day " + days , Toast.LENGTH_LONG).show();



}

    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }


}

