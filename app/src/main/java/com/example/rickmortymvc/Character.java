package com.example.rickmortymvc;

public class Character {
    private final String name;
    private final String status;
    private final String image;

    public Character(String name, String status, String image) {
        this.name = name;
        this.status = status;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

}
