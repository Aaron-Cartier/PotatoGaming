package com.example.potatogaming.model;

public class TopSellers {
    Integer id;
    Integer imageUrl;

    public TopSellers(Integer id, Integer imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImage(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
