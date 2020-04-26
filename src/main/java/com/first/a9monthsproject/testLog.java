package com.first.a9monthsproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class testLog extends AppCompatActivity {

    private ListView testsList;
    private Button addButton;
    private Button showMyTestList;
    private EditText testName;

    List<String> keyList;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    //for save the test list to database
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth firebaseAuth;
    private static final String TAG = "MainActivity";
    public String userId;

    private long mLastClickTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_log);



        //xml
        addButton= (Button) findViewById(R.id.addtest);
        testName = (EditText) findViewById(R.id.inputText);
        testsList = (ListView) findViewById(R.id.listView);
        showMyTestList = (Button) findViewById(R.id.showList);


        //firebase
        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        final FirebaseUser user = firebaseAuth.getCurrentUser();



        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        //list
        keyList = new ArrayList<String>();
        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(testLog.this ,android.R.layout.simple_list_item_1,arrayList);
        testsList.setAdapter(arrayAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SystemClock.elapsedRealtime() - mLastClickTime < 10000) {
                    return;
                }
                else {
                    mLastClickTime = SystemClock.elapsedRealtime();

                    String string = testName.getText().toString();
                    arrayList.add(string);
                    mDatabaseReference.child("MUsers").child(user.getUid()).child("Tests_List").push().setValue(string);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });









        showMyTestList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyTestList();
            }
        });



    }

    private void openMyTestList() {

        Intent in = new Intent(this, MyTestList.class);
        startActivity(in);
    }



}
