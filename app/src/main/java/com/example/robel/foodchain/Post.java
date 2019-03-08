package com.example.robel.foodchain;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.sql.Struct;

public class Post extends JSONObject {

    @SerializedName("type")
    private String type;


    @SerializedName("company")
    private String company;

    @SerializedName("grower")
    private String grower;

    @SerializedName("package")
    private String pack;

    @SerializedName("date")
    private String date;

    @SerializedName("res")
    private String res;





    public String getRes(){
        return res;
    }
    public String getType() {
        return type;
    }
    public String getCompany(){
        return company;
    }
    public String getGrower(){
        return grower;
    }
    public String getPackageItem(){
        return pack;
    }
    public String getDate(){
        return date;
    }

}