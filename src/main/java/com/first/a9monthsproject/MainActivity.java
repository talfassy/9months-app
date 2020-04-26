package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mUser;
    private Button loginButton;
    private Button createButton;
    private EditText email;
    private EditText password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginButton = (Button) findViewById(R.id.logButton) ;
        createButton =(Button) findViewById(R.id.createAccount);
        email = (EditText) findViewById(R.id.emailAd);
        password = (EditText) findViewById(R.id.passwordAd);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            //here we can see if the user is connected or not
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                // the user is singed in now
                mUser = firebaseAuth.getCurrentUser();
                // check ths connection of the app to the database
                if (mUser != null){
                    Toast.makeText(MainActivity.this, "singed in!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "not singed in 1!", Toast.LENGTH_LONG).show();

                }

            }
        };

        //handle the registration
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistrationPage();
            }
        });

        //handle login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(email.getText().toString())&& !TextUtils.isEmpty(password.getText().toString())){

                    String tempEmail= email.getText().toString();
                    String tempPass = password.getText().toString();

                    loginFun(tempEmail,tempPass);

                }else{

                }
            }
        });
    }

    private void loginFun(String tempEmail, String tempPass) {
      mAuth.signInWithEmailAndPassword(tempEmail, tempPass)
              .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                        //check connection of the user to the database
                      if (task.isSuccessful()){
                       //we are in
                       Toast.makeText(MainActivity.this , "", Toast.LENGTH_LONG).show();
                       openHomePage();
                      }else{
                          // not singed in
                          Toast.makeText(MainActivity.this, "Wrong email or password", Toast.LENGTH_LONG).show();
                      }

                  }
              });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    // use the fun to move on to home page
    public void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }

    //use fun to move on to registration page
    public void openRegistrationPage() {
        Intent in = new Intent(this, registeration.class);
        startActivity(in);
    }
}
/*
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("message");
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "MainActivity";
    private EditText email;
    private EditText pass;
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.emailAd);
        pass = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.logButton);
        register = (Button) findViewById(R.id.registration);

        mAuth = FirebaseAuth.getInstance();
        myRef.setValue("Hello, timor!!");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        // take care to user login
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user != null) {
                    //user singed in
                    Log.d(TAG, "singed in");
                    // Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_LONG).show();

                } else {
                    //user singed out
                    Log.d(TAG, "singed out");
                    //  Toast.makeText(MainActivity.this, "No", Toast.LENGTH_LONG).show();
                }


            }
        };
        // take care to login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmpEmail = email.getText().toString();
                String tmpPass = pass.getText().toString();

                ///check if the input is not empty
                if (!tmpEmail.equals("") && !tmpPass.equals("")) {
                    mAuth.signInWithEmailAndPassword(tmpEmail, tmpPass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_LONG).show();
                                //  Log.d(TAG,"success");
                                Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                                openHomePage();

                            } else {
                                //Toast.makeText(MainActivity.this, "singed in!!", Toast.LENGTH_LONG).show();
                                // Log.w(TAG,"failed", task.getException());

                                Toast.makeText(MainActivity.this, "Incorrect contact details ", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistrationPage();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth.addAuthStateListener(mAuthListener);
        // updateUI(currentUser);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);

        }
    }

    // use the fun to move on to home page
    public void openHomePage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }

    //use fun to move on to registration page
    public void openRegistrationPage() {
        Intent in = new Intent(this, registeration.class);
        startActivity(in);
    }
}
*/