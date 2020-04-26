package com.first.a9monthsproject;

//main activity responsible for uploading the image to Data Base,
// add the image to firebase
// uplaod the image from the gallery on the phone

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.net.URI;

public class addImageToAlbum extends AppCompatActivity {



    private static final int PICK_IMAGE_REQUEST =1;
    private Button chooseImageButton;
    private Button uploadButton;
    private EditText addTitle;
    private ImageView myImage;
    private TextView showImage;
    private ProgressBar mProgressBar;
    private Uri ImageUri; //point to our image and upload to firebase storage

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private FirebaseAuth mAuth;

    private StorageTask mUploadTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image_to_album);

        chooseImageButton=findViewById(R.id.chooseImage);
        uploadButton = findViewById(R.id.uploadImage);
        addTitle =findViewById(R.id.addTitle_editText);
        showImage = findViewById(R.id.showUploads);
        myImage =findViewById(R.id.image);
        mProgressBar =findViewById(R.id.buttonUploadProgres);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
       String userId = user.getUid();


        //save the images in "uploads" folder in firebase storage
        mStorageRef= FirebaseStorage.getInstance().getReference().child("MUsers").child(userId).child("Uploads");

    //child("MUsers").child(userId).child("Uploads");
        mDatabaseRef =FirebaseDatabase.getInstance().getReference().child("MUsers").child(userId).child("Uploads");
    //child("MUsers").child(userId).child("Uploads");

        chooseImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mUploadTask help us to prevent the user click many time on the upload button and upload the same pic  few times
                if(mUploadTask != null && mUploadTask.isInProgress()){
                    Toast.makeText(addImageToAlbum.this, "upload in progress..", Toast.LENGTH_SHORT).show();
                }else {
                    uploadFileFunc();
                }

            }
        });

        showImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesAlbum();

            }
        });


    }



    //The function is responsible for handling the situation in which the user
    // selected an image with an incorrect extension or an incorrect image
    private String getFileEx(Uri uri){
        ContentResolver cR = getContentResolver();
       MimeTypeMap mime= MimeTypeMap.getSingleton();
       return mime.getExtensionFromMimeType(cR.getType(uri));

}

    private void openFileChooser() {
        Intent intent =new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    private void uploadFileFunc() {

        //check id the user select an image
        if (ImageUri !=null){
            StorageReference fileRef = mStorageRef.child("Upload/" + System.currentTimeMillis()+"." + getFileEx(ImageUri));

            //mUploadTask help us to check if the user clicked few time on the upload button
            mUploadTask= fileRef.putFile(ImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    //The image was successfully uploaded
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(0); // set progress bar to zero
                        }
                        //delay for progress bar of 5 sec
                    }, 500);
                    Toast.makeText(addImageToAlbum.this, "The image was successfully uploaded", Toast.LENGTH_SHORT).show();

                    Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                    while (!urlTask.isSuccessful());
                    Uri downloadUrl = urlTask.getResult();

                    UploadImage upload = new UploadImage(addTitle.getText().toString().trim(),downloadUrl.toString() );

                   // Uniqueness of the file uploaded by a specific ID
                    String uploadID= mDatabaseRef.push().getKey();
                    mDatabaseRef.child(uploadID).setValue(upload);
                }

            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    //upload is failed
                    Toast.makeText(addImageToAlbum.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                    //Uploading image is in progress => show how long the progress takes
                    double progress = (100.0 * taskSnapshot.getBytesTransferred() /taskSnapshot.getTotalByteCount());
                    mProgressBar.setProgress((int) progress);
                }
            });
        }else{
            Toast.makeText(this,"no file selected", Toast.LENGTH_LONG).show();
        }
    }

    private void openImagesAlbum() {
        Intent in = new Intent(this,imagesAlbum.class);
        startActivity(in);

    }

    //help us to pick a file
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() !=null){

            //now we get the image we choose
            ImageUri = data.getData();

            //add the image we choose to the imageView
            Picasso.with(this).load(ImageUri).into(myImage);

        }
    }
}




















