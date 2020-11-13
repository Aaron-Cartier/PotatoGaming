package com.example.potatogaming;

public class gameRequest {
    private String gmTitle;
    private String gmDescription;
    private String gmPlatform;
    private String gmDeveloper;
    private String gmPrice;
    private String gmImage;
    private String key;

    public gameRequest(){}

    public gameRequest(String gmTitle, String gmDescription, String gmPlatform, String gmDeveloper, String gmPrice, String gmImage) {
        this.gmTitle = gmTitle;
        this.gmDescription = gmDescription;
        this.gmPlatform = gmPlatform;
        this.gmDeveloper = gmDeveloper;
        this.gmPrice = gmPrice;
        this.gmImage = gmImage;
    }

    public String getGmTitle() {
        return gmTitle;
    }

    public String getGmDescription() {
        return gmDescription;
    }

    public String getGmPlatform() {
        return gmPlatform;
    }

    public String getGmDeveloper() {
        return gmDeveloper;
    }

    public String getGmPrice() {
        return gmPrice;
    }

    public String getGmImage() {
        return gmImage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
