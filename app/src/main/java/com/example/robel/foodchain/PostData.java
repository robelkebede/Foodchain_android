package com.example.robel.foodchain;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostData{

    @SerializedName("lat")
    @Expose
    private double lat;

    @SerializedName("lng")
    @Expose
    private double lng;


    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    @SerializedName("item")
    @Expose
    private String item;

    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("grower")
    @Expose
    private String grower;

    public PostData(double lat, double lng, String timestamp, String item, String company, String grower) {
        this.lat = lat;
        this.lng = lng;
        this.timestamp = timestamp;
        this.item = item;
        this.company = company;
        this.grower = grower;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setGrower(String grower) {
        this.grower = grower;
    }
}
