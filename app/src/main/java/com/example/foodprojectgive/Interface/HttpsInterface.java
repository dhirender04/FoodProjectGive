package com.example.foodprojectgive.Interface;

import com.example.foodprojectgive.Models.LogInModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HttpsInterface {
    @FormUrlEncoded
    @POST("user/login")
    Call<LogInModel> logInUser(
            @Field("mobile") String mobile,
            @Field("password") String password
    );
}
