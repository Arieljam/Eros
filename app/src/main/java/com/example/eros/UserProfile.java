package com.example.eros;

public class UserProfile {
    private String id;
    private String name;
    private int age;
    private String bio;
    private String photoUrl;

    public UserProfile(String id, String name, int age, String bio, String photoUrl) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bio = bio;
        this.photoUrl = photoUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBio() {
        return bio;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
