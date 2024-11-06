package com.example.latihanuts3;

public class PlayerModel {
    String name, position, description;
    int image;

    public PlayerModel(String name, String position, String description, int image) {
        this.name = name;
        this.position = position;
        this.description = description;
        this.image = image;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
