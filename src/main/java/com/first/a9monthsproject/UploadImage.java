package com.first.a9monthsproject;
// java class that represents the item image

import com.google.firebase.database.Exclude;

public class UploadImage {

    private String mName; //image name
    private String mImageUrl; // image url address
    private String mKey; // image unique key in the database



    public UploadImage(){};

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    @Exclude
    public String getmKey() {
        return mKey;
    }

    @Exclude
    public void setmKey(String mKey) {
        this.mKey = mKey;
    }


    public UploadImage(String name, String image){

        if(name.trim().equals("")){
         name="no name";

        }
        mName=name;
        mImageUrl=image;

    }
}
