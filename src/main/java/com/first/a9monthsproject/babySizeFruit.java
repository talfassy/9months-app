package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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

public class babySizeFruit extends AppCompatActivity {

    private Calendar myCalendar;
    private TextView fruitSizeText;
    private ImageView imageViewFruit;
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
        setContentView(R.layout.activity_baby_size_fruit);

        logoButton= findViewById(R.id.Image_Logo);

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mDb = mDatabase.getReference();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userKey = user.getUid();
        //Toast.makeText(pregnancyCalender.this, "week" + userKey , Toast.LENGTH_LONG).show();


        mDb.child("MUsers").child(userKey).child("Pregnancy_week").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userId = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Date: " + userId);
              //  Toast.makeText(babySizeFruit.this, "week " + userId , Toast.LENGTH_LONG).show();

                fruitSizeText=(TextView)findViewById(R.id.fruitSize);
                imageViewFruit=(ImageView) findViewById(R.id.fruitImage);

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
                int weeks= (int) (days/7.0);


                //Checking the week the user is in and show the size of her fetus accordingly

                {
                    if (weeks == 4) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a poppy seed size");
                        imageViewFruit.setImageResource(R.drawable.poppyseeds);
                    }
                    if (weeks == 5) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in apple seed size ");
                        imageViewFruit.setImageResource(R.drawable.appleseed);
                    }
                    if (weeks == 6) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a pea size ");
                        imageViewFruit.setImageResource(R.drawable.pea);
                    }
                    if (weeks == 7) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a blueberry size ");
                        imageViewFruit.setImageResource(R.drawable.blueberry);
                    }
                    if (weeks == 8) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a raspberry size ");
                        imageViewFruit.setImageResource(R.drawable.raspberry);
                    }
                    if (weeks == 9) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in an olive size ");
                        imageViewFruit.setImageResource(R.drawable.olive);
                    }
                    if (weeks == 10) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a dried plum size ");
                        imageViewFruit.setImageResource(R.drawable.driedplum);
                    }
                    if (weeks == 11) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a strawberry size ");
                        imageViewFruit.setImageResource(R.drawable.strawberry);
                    }
                    if (weeks == 12) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a plum size ");
                        imageViewFruit.setImageResource(R.drawable.plum);
                    }
                    if (weeks == 13) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a lime size ");
                        imageViewFruit.setImageResource(R.drawable.lime);
                    }
                    if (weeks == 14) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a kiwi size ");
                        imageViewFruit.setImageResource(R.drawable.kiwi);
                    }
                    if (weeks == 15) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a tomato size ");
                        imageViewFruit.setImageResource(R.drawable.tomato);
                    }
                     if (weeks == 16) {
                         fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a peach size ");
                         imageViewFruit.setImageResource(R.drawable.peach);
                     }
                     if (weeks == 17) {
                         fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a lemon size ");
                         imageViewFruit.setImageResource(R.drawable.lemon);
                     }
                    if (weeks == 18) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in an apple size ");
                        imageViewFruit.setImageResource(R.drawable.apple);
                    }
                    if (weeks == 19) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in an onion size ");
                        imageViewFruit.setImageResource(R.drawable.onion);
                    }
                    if (weeks == 20) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in an orange size ");
                        imageViewFruit.setImageResource(R.drawable.orange);
                    }
                    if (weeks == 21) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a pepper size ");
                        imageViewFruit.setImageResource(R.drawable.pepper);
                    }
                    if (weeks == 22) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in an avocado size ");
                        imageViewFruit.setImageResource(R.drawable.avocado);
                    }
                    if (weeks == 23) {
                        fruitSizeText.setText("You are in week " + weeks+" and your fetus is in a sweet potato size ");
                        imageViewFruit.setImageResource(R.drawable.sweetpotato);
                    }
                    if (weeks == 24) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a mango size ");
                        imageViewFruit.setImageResource(R.drawable.mango);
                    }
                    if (weeks == 25) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a cucumber size ");
                        imageViewFruit.setImageResource(R.drawable.cucumber);
                    }
                    if (weeks == 26) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a banana size ");
                        imageViewFruit.setImageResource(R.drawable.banana);
                    }
                    if (weeks == 27) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a pomegranate size ");
                        imageViewFruit.setImageResource(R.drawable.pomegranate);
                    }
                    if (weeks == 28) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a papaya size ");
                        imageViewFruit.setImageResource(R.drawable.papaya);
                    }
                    if (weeks == 29) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in an eggplant size ");
                        imageViewFruit.setImageResource(R.drawable.eggplant);
                    }
                    if (weeks == 30) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a squash size ");
                        imageViewFruit.setImageResource(R.drawable.squash);
                    }
                    if (weeks == 31) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a grapefruit size ");
                        imageViewFruit.setImageResource(R.drawable.grapefruit);
                    }
                    if (weeks == 32) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a pineapple size ");
                        imageViewFruit.setImageResource(R.drawable.pineapple);
                    }
                    if (weeks == 33) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a melon size ");
                        imageViewFruit.setImageResource(R.drawable.melon );
                    }
                    if (weeks == 34) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a cauliflower size ");
                        imageViewFruit.setImageResource(R.drawable.cauliflower);
                    }
                    if (weeks == 35) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a cabbage size ");
                        imageViewFruit.setImageResource(R.drawable.cabbage);
                    }
                    if (weeks == 36) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a lettuce size ");
                        imageViewFruit.setImageResource(R.drawable.lettuce);
                    }
                    if (weeks == 37) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a pomelo size ");
                        imageViewFruit.setImageResource(R.drawable.pomelo );
                    }
                    if (weeks == 38) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a coconut size ");
                        imageViewFruit.setImageResource(R.drawable.coconut);
                    }
                    if (weeks == 39) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a pumpkin size ");
                        imageViewFruit.setImageResource(R.drawable.pumpkin);
                    }
                    if (weeks == 40) {
                        fruitSizeText.setText("You are in week " + weeks + " and your fetus is in a watermelon size ");
                        imageViewFruit.setImageResource(R.drawable.watermelon);
                    }








                }


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


    }

    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);

    }

}
