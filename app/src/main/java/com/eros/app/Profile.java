package com.eros.app;

public class Profile {
    private String name;
    private int age;
    private String imageUrl;

    public Profile(String name, int age, String imageUrl) {
        this.name = name;
        this.age = age;
        this.imageUrl = imageUrl;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getImageUrl() { return imageUrl; }
}
