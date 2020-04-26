package com.first.a9monthsproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class decodingResults_urine extends AppCompatActivity {

    private ImageButton logoButton;
    private TextView title;
    private ListView list;
    private Button returnBtn;
    List<String> keyList;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    //check test value
    private TextView checkNitrite;
    private TextView checkLeucocytes;
    private TextView checkPh;
    public TextView checkProtein;
    private TextView checkGlu;
    private TextView checkKetones;
    private TextView checkUroblinogen;
    private TextView checkBilirubin;
    private TextView checkEry;



    private TextView Nitrite_recommendation;
    private TextView Leucocytes_recommendation;
    private TextView ph_recommendation;
    private TextView Protein_recommendation;
    private TextView glu_recommendation;
    private TextView Ketones_recommendation;
    private TextView Uroblinogen_recommendation;
    private TextView Bilirubin_recommendation;
    private TextView Ery_recommendation;




    //firebase
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoding_results_urine);


        title = (TextView) findViewById(R.id.urineTestsResult);
        list = (ListView) findViewById(R.id.listViewId);
        returnBtn =(Button) findViewById(R.id.returnButton);
        logoButton = findViewById(R.id.Image_Logo);

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTestsPage();
            }
        });

        //list of tests result
        arrayList = new ArrayList<String>();
        keyList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(decodingResults_urine.this ,android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(arrayAdapter);


        //check scan values
        checkNitrite = findViewById(R.id.Nitrite_result) ;
        checkLeucocytes = findViewById(R.id.Leucocyets_result) ;
        checkPh = findViewById(R.id.ph_result) ;
        checkProtein = findViewById(R.id.Proteine_result) ;
        checkGlu = findViewById(R.id.Glucose_result) ;
        checkKetones = findViewById(R.id.Keytones_result) ;
        checkUroblinogen = findViewById(R.id.Uroblinogen_result) ;
        checkBilirubin =  findViewById(R.id.Bilirubin_result) ;
        checkEry =  findViewById(R.id.EryThrocytes_result) ;

        Nitrite_recommendation= findViewById(R.id.Nitrite_result_rec);
        Leucocytes_recommendation = findViewById(R.id.Leucocyets_result_rec) ;
        ph_recommendation = findViewById(R.id.ph_result_rec) ;
        Protein_recommendation = findViewById(R.id.Proteine_result_rec);
        glu_recommendation =findViewById(R.id.Glucose_result_rec);
        Ketones_recommendation =findViewById(R.id.Keytones_result_rec);
        Uroblinogen_recommendation = findViewById(R.id.Uroblinogen_result_rec) ;
        Bilirubin_recommendation =findViewById(R.id.Bilirubin_result_rec);
        Ery_recommendation =findViewById(R.id.EryThrocytes_result_rec);


        //set up firebase
        mDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        userId = user.getUid();
        //FirebaseUser users = myFirebaseRef.child("users");
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("MUsers").child(userId).child("Tests_result_urine");


        mDatabaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(String.class);
                arrayList.add(value); // include the scan values
                keyList.add(dataSnapshot.getKey()); //include the id of each tests
                arrayAdapter.notifyDataSetChanged();


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {


            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String resultValue = arrayAdapter.getItem(position);
                String[] result = resultValue.split(" ");

                checkValuesNitrite(result);
                checkValuesLeucocytes(result);
                checkValuesPh(result);
                checkValuesProtein(result);
                checkValuesGlucose(result);
                checkValuesKeytones(result);
                checkValuesUroblinogen(result);
                checkValuesBilirubin(result);
                checkValuesERY(result);


            }// end of onItemClick
        }); //end of setOnItemClickListener

    }// end


    //provide decoding to nitrite tests
    private void checkValuesNitrite( String[] str){

        if ((str[11]).equals("Negative")) {
            checkNitrite.setText("Your result is negative - therefore the value is proper.");

            //provide recommendations
            Nitrite_recommendation.setText("No recommendations are available - your values are proper.");;

        } else if ((str[11]).equals("Positive")) {
            checkNitrite.setText("Your result is positive - therefore the value is not proper ! ");

            //provide recommendations for positive Nitrite
            Nitrite_recommendation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkFunc("NitritePos");
                }
            });

        }
    }

    //provide decoding to Leucocytes tests
    private void checkValuesLeucocytes( String[] str){

        if ((str[12]).equals("Negative")) {
            checkLeucocytes.setText("Your result is negative - therefore the value is proper.");

            //provide recommendations
            Leucocytes_recommendation.setText("No recommendations are available - your values are proper.");;

        } else if ((str[12]).equals("Positive")) {
            checkLeucocytes.setText("Your result is positive - therefore the value is not proper ! ");

            //provide recommendations for positive Nitrite
            Leucocytes_recommendation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkFunc("LeucocytesPos");
                }
            });

        }
    }

    //provide decoding to ph tests
    private void checkValuesPh (String[] str){

        if (Double.valueOf(str[13]) < 4) {
            checkPh.setText("Your values are below the correct range");

            //provide recommendations
            ph_recommendation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkFunc("lowPH");

                }
            });

        } else if (Double.valueOf(str[13]) > 8) {
            checkPh.setText("Your values are above the correct range ");

            //provide recommendations for positive Nitrite
            ph_recommendation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkFunc("highPH");
                }
            });

        }
        else {
            checkPh.setText("Your blood PH levels are in the correct range");
            ph_recommendation.setText("No recommendations are available - your values are in the correct range.");
        }
    }

    //provide decoding to Protein tests
    private void checkValuesProtein( String[] str){

        if ((str[14]).equals("Negative")) {
            checkProtein.setText("Your result is negative - therefore the value is proper.");

            //provide recommendations
            Protein_recommendation.setText("No recommendations are available - your values are proper.");;

        } else  {
            checkProtein.setText("Your urine contains protein and therefore the test results are abnormal ");

            //provide recommendations for positive Nitrite
            Protein_recommendation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkFunc("ProteinePos");
                }
            });

        }
    }

    //provide decoding to glucose tests
    private void  checkValuesGlucose( String[] str){

        if ((str[15]).equals("Negative")) {
            checkGlu.setText("Your result is negative - therefore the value is proper.");

            //provide recommendations
            glu_recommendation.setText("No recommendations are available - your values are proper.");;

        } else if ((str[15]).equals("Positive")) {
            checkGlu.setText("Your result is positive - therefore the value is not proper ! ");

            //provide recommendations for positive Nitrite
            glu_recommendation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkFunc("GlucosePos");
                }
            });

        }
    }

    //provide decoding to Keytones tests
    private void  checkValuesKeytones( String[] str) {

        if ((str[16]).equals("Negative")) {
            checkKetones.setText("Your result is negative - therefore the value is proper.");

            //provide recommendations
            Ketones_recommendation.setText("No recommendations are available - your values are proper.");
            ;

        } else if ((str[16]).equals("Positive")) {
            checkKetones.setText("Your result is positive - therefore the value is not proper ! ");

            //provide recommendations for positive Nitrite
            Ketones_recommendation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkFunc("KetonesPos");
                }
            });

        }


    }


    //provide decoding to Bilirubin tests
    private void  checkValuesUroblinogen( String[] str) {

        if ((str[17]).equals("Normal")) {
            checkUroblinogen.setText("Your result is Normal - therefore the value is proper.");

            //provide recommendations
            Uroblinogen_recommendation.setText("No recommendations are available - your values are proper.");
            ;

        } else if ((str[17]).equals("Abnormal")) {
            checkUroblinogen.setText("Your result is Abnormal - therefore the value is not proper ! ");

            //provide recommendations for positive Nitrite
            Uroblinogen_recommendation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkFunc("UroblinogenPos");
                }
            });

        }


    }

    //provide decoding to Keytones tests
    private void checkValuesBilirubin( String[] str) {

        if ((str[18]).equals("Negative")) {
            checkBilirubin.setText("Your result is negative - therefore the value is proper.");

            //provide recommendations
            Bilirubin_recommendation.setText("No recommendations are available - your values are proper.");
            ;

        } else if ((str[18]).equals("Positive")) {
            checkBilirubin.setText("Your result is positive - therefore the value is not proper ! ");

            //provide recommendations for positive Nitrite
            Bilirubin_recommendation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkFunc("BilirubinPos");
                }
            });

        }


    }


    //provide decoding to checkValuesERY tests
    private void checkValuesERY( String[] str) {

        if ((str[19]).equals("Negative")) {
            checkEry.setText("Your result is negative - therefore the value is proper.");

            //provide recommendations
            Ery_recommendation.setText("No recommendations are available - your values are proper.");
            ;

        } else if ((str[19]).equals("Positive")) {
            checkEry.setText("Your result is positive - therefore the value is not proper ! ");

            //provide recommendations for positive Nitrite
            Ery_recommendation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkFunc("EryThrocytesPos");
                }
            });

        }


    }




    private void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }

    private void openTestsPage() {
        Intent in = new Intent(this , tests.class);
        startActivity(in);
    }

    //The function passes the value for which we want to provide the recommendation to the recommendations activity
    private void checkFunc(String s){

        Intent i = new Intent (this, urine_recommendations.class);

        i.putExtra("key", s);
        startActivity(i);
    }
}
