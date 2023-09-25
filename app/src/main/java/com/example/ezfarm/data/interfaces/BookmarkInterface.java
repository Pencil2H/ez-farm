package com.example.ezfarm.data.interfaces;

import com.example.poe_life.data.model.BookmarkAddData;
import com.example.poe_life.data.model.BookmarkDeleteData;
import com.example.poe_life.data.model.BookmarkGetData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BookmarkInterface {
    @FormUrlEncoded
    @POST("poem/get_bookmarks")
    Call<BookmarkGetData> getMyBookmark(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("misc/bookmark_poem")
    Call<BookmarkAddData> addMybookmark(@Field("userId") String userId,
                                        @Field("poemId") String poemId);

    @FormUrlEncoded
    @POST("misc/remove_bookmark")
    Call<BookmarkDeleteData> deleteMybookmark(@Field("userId") String userId,
                                              @Field("poemId") String poemId);
}
