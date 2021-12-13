package com.example.quadram;

import com.example.quadram.recyclerfree.aplicacion;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONResponse {
    private aplicacion[] feed;

    public aplicacion[] getFeed() {
        return feed;
    }

    public void setFeed(aplicacion[] feed) {
        this.feed = feed;
    }
}
