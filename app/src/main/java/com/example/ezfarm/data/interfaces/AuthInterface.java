package com.example.ezfarm.data.interfaces;

import com.example.poe_life.data.model.LoginData;
import com.example.poe_life.data.model.RegisterData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthInterface {

    @FormUrlEncoded
    @POST("auth/register")
    Call<RegisterData> Register(@Field("username") String username,
                                @Field("NIM") String nim,
                                @Field("email") String email,
                                @Field("password") String password);
    @FormUrlEncoded
    @POST("auth/login")
    Call<LoginData> login(@Field("username") String username,
                          @Field("password") String password);
}