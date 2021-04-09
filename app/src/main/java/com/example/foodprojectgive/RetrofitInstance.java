package com.example.foodprojectgive;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static String baseUrl = "149.129.183.111/userapi/api/";
   private static Retrofit retrofit;
    private  static  Retrofit.Builder builder;
    public static Retrofit get(){
        if (retrofit!=null){
            return retrofit;
        }
        builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


}
