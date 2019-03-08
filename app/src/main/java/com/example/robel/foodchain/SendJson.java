package com.example.robel.foodchain;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SendJson{
    @POST("/data_insight")
    Call<PostData> getAcssesData(@Body result res);
}
