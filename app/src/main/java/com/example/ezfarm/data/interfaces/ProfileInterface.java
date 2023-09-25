package com.example.ezfarm.data.interfaces;

import com.example.poe_life.data.model.FollowerUserData;
import com.example.poe_life.data.model.ProfileEditData;
import com.example.poe_life.data.model.ProfileGetUserData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProfileInterface {
    @FormUrlEncoded
    @POST("profile/edit_profile")
    Call<ProfileEditData> login(@Field("userId") String userId,
                                @Field("email") String email,
                                @Field("username") String username);
//                             @Field("type") String type (image masih ada Warning)
    @FormUrlEncoded
    @POST("profile/do_follow")
    Call<FollowerUserData> getFollowUserData(@Field("userId") String userId,
                                             @Field("viewerId") String viewerId,
                                             @Field("isFollowing") String isFollowing);
    @FormUrlEncoded
    @POST("profile/get_user_profile")
    Call<ProfileGetUserData> getUserProfileData(@Field("userId") String userId,
                                                @Field("viewerId") String viewerId);

}
