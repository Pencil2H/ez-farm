package com.example.ezfarm.data.interfaces;

import com.example.poe_life.data.model.CommentGetData;
import com.example.poe_life.data.model.CommentWriteData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CommentInterface {
    @FormUrlEncoded
    @POST("poem/get_comment")
    Call<CommentGetData> Getcomment(@Field("poemId") String poemId);

    @FormUrlEncoded
    @POST("poem/delete_comment")
    Call<CommentGetData> DeleteComment(@Field("commentId") String commentId);

    @FormUrlEncoded
    @POST("poem/write_comment")
    Call<CommentWriteData> WriteComment(@Field("poemId") String poemId,
                                        @Field("comment")String comment,
                                        @Field("userId")String userId);
}
