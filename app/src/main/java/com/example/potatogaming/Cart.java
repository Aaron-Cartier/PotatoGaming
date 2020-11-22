package com.example.potatogaming;

public class Cart {
    private String gmTitle;
    private String gmPrice;
    private String key;

    public Cart() {
    }

    public Cart(String gmTitle, String gmPrice) {
        this.gmTitle = gmTitle;
        this.gmPrice = gmPrice;
    }

    public String getGmTitle() {
        return gmTitle;
    }

    public String getGmPrice() {
        return gmPrice;
    }

    public void setGmTitle(String gmTitle) {
        this.gmTitle = gmTitle;
    }

    public void setGmPrice(String gmPrice) {
        this.gmPrice = gmPrice;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
