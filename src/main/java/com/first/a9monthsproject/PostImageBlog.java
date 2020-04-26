package com.first.a9monthsproject;

public class PostImageBlog {
    public String title;
    public String image;
    public String time;
    public String userId;

    public PostImageBlog() {
    }

    public PostImageBlog(String title, String iamge, String time, String userId) {
        this.title = title;
        this.image = iamge;
        this.time = time;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIamge() {
        return image;
    }

    public void setIamge(String iamge) {
        this.image = iamge;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
