package com.first.a9monthsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hoosingOptionImageAlbum extends AppCompatActivity {

    private Button addImageButton;
    private Button watchAlbumButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoosing_option_image_album);

        addImageButton =(Button) findViewById(R.id.addImageToAlbum);
        watchAlbumButton = (Button) findViewById(R.id.WatchAlbum);

        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddToAlbum();
            }
        });

        watchAlbumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageAlbum();
            }
        });
    }
    //move to images album page
    private void openImageAlbum() {
        Intent in = new Intent(this, imagesAlbum.class);
        startActivity(in);
    }

    //move to add image to album page
    private void openAddToAlbum() {
        Intent in = new Intent(this, addImageToAlbum.class);
        startActivity(in);
    }
}
