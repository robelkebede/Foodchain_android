package com.example.robel.foodchain;

import android.content.Intent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Json {

    @GET("/id/{id}")
    Call<Post> getData(@Path("id") String id);

    @POST("/data_insight")
    Call<PostData> createpost(@Body PostData post);


}
