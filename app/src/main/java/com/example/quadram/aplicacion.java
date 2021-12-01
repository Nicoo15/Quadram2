package com.example.quadram;

public class aplicacion {

    private String imgpost;
    private String appname;
    private String autor;
    private String price;

    public String getImgpost() {
        return imgpost;
    }

    public void setImgpost(String imgpost) {
        this.imgpost = imgpost;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public aplicacion(String imgpost, String appname, String autor, String price) {
        this.imgpost = imgpost;
        this.appname = appname;
        this.autor = autor;
        this.price = price;


    }
}
