package com.example.prototype2;

public class User {

    public String id;
    public String username;
    public String imageURL;
    public String gender;
    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(String id, String username, String imageURL, String gender) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.gender = gender;
    }
}
