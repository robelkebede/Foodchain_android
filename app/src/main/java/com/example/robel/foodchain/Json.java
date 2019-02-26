package com.example.robel.foodchain;

import android.content.Intent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Json {

    @GET("/id/{id}")
    Call<Post> getData(@Path("id") String id);
}
