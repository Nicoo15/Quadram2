package com.example.quadram.recyclerfree;

import android.widget.ImageView;

public class aplicacion {

    private ImageView image;
    private String name;
    private String artist;
    private String price;

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public aplicacion(ImageView image, String name, String artist, String price) {
        this.image = image;
        this.name = name;
        this.artist = artist;
        this.price = price;


    }

    @Override
    public String toString() {
        return "aplicacion{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}