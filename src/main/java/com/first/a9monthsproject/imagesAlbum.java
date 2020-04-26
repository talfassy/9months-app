package com.first.a9monthsproject;

//here you will see the photos after clicking on "show uploads" in "addImageToAlbum" activity
//here we will display all the details about the uploads images
// we will display all the images uploaded to Data Base
// upload the images to the app

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class
imagesAlbum extends AppCompatActivity implements ImageAdapter.OnItemClickListener {

    private RecyclerView mRecycle;
    private ImageAdapter mAdapter;
    private List<UploadImage> mUploads;
    private DatabaseReference mDatabaseRef;

    private ProgressBar mProgressCircle;


    private FirebaseStorage mStorage;
    private FirebaseDatabase database;

    private ValueEventListener mDBlisnter;
    private FirebaseAuth mAuth;

    private ImageButton logobtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_album);

        logobtn = findViewById(R.id.Image_Logo);
        logobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomepage();
            }
        });


        mRecycle = findViewById(R.id.recycleView);
        mRecycle.setHasFixedSize(true);
        mRecycle.setLayoutManager(new LinearLayoutManager(this));

        mProgressCircle = findViewById(R.id.progressCircle);

        mUploads = new ArrayList<>();

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String userId = user.getUid();

        mStorage = FirebaseStorage.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("MUsers").child(userId).child("Uploads");

        //The adapter provides access to the data items
        // adapter is also responsible for making a view for each item in the data set.
        mAdapter = new ImageAdapter(imagesAlbum.this, mUploads);
        mRecycle.setAdapter(mAdapter);
        mAdapter.setOnItemClickListner(imagesAlbum.this);

        mStorage = FirebaseStorage.getInstance();
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();



        mDBlisnter = mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUploads.clear();

                //we get the the image\message from the database
                //dataSnapshot is a list that represent the data ( our uploads items)
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                    //change the datasnapshot to uplaodImage item
                    //the key of the upload image is inside the snapshot
                    UploadImage upload = postSnapShot.getValue(UploadImage.class);
                    upload.setmKey(postSnapShot.getKey()); //give us the key
                    mUploads.add(upload);
                }

                mAdapter.notifyDataSetChanged();

                mAdapter.notifyDataSetChanged();
                mRecycle.setAdapter(mAdapter);
                mProgressCircle.setVisibility(View.INVISIBLE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //when we have error ( don't allowed to read from the data base)
                Toast.makeText(imagesAlbum.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });


    }

    private void openHomepage() {
        Intent in = new Intent(this, homePage.class);
        startActivity(in);
    }

    @Override
    public void OnItemClick(int position) {


    }

    @Override
    public void OnDeleteClick(int position) {

     // Toast.makeText(this, "delete image" , Toast.LENGTH_LONG).show();
        UploadImage selectItem = mUploads.get(position);
        final String selcetKey = selectItem.getmKey();

        StorageReference imageRef = mStorage.getReferenceFromUrl(selectItem.getmImageUrl());

        imageRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                // we want delete only items that are in our database thats why we use onSuccess method
                //remove from the database according to the unique image key that was selected
                mDatabaseRef.child(selcetKey).removeValue();
                Toast.makeText(imagesAlbum.this, "the image deleted successfully", Toast.LENGTH_LONG).show();
            }
        });


}

//the function delete the event listener of the image that wes deleted
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDatabaseRef.removeEventListener(mDBlisnter);
    }


}
