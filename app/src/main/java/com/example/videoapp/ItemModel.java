package com.example.videoapp;

public class ItemModel {

    private String name, age, place, image_url;

    public ItemModel() {
    }

    public ItemModel(String image, String name, String age, String place) {
        this.image_url = image;
        this.name = name;
        this.age = age;
        this.place = place;
    }

    public String getImage() {
        return image_url;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getPlace() {
        return place;
    }
}