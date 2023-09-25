package com.example.ezfarm.data.interfaces;

import com.example.poe_life.data.model.ProfileEditData;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface EditProfileInterface {
        @Multipart
        @POST("profile/edit_profile")
        Call<ProfileEditData> uploadImage(@Part("userId") RequestBody userId
                                       , @Part MultipartBody.Part image
                                       , @Part("email") RequestBody email
                                       , @Part("username") RequestBody username
                                       , @Part("nim") RequestBody nim
                                        );
}
