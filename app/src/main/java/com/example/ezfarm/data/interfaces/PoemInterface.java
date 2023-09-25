package com.example.ezfarm.data.interfaces;

import com.example.poe_life.data.model.PoemDetailData;
import com.example.poe_life.data.model.PoemListData;
import com.example.poe_life.data.model.PoemWriteData;
import com.example.poe_life.data.model.ReactionData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PoemInterface {
    @FormUrlEncoded
    @POST("poem/get_poem_list")
    Call<PoemListData> Allpoemcall(@Field("userId") String userId,
                                   @Field("type")String published);

    @FormUrlEncoded
    @POST("poem/get_poem_list")
    Call<PoemListData> Allpoemcallcat(@Field("userId") String userId,
                                      @Field("catId") String catId);
    @GET("poem/popular_poem")
    Call<PoemListData> getPopularPoem(@Query("uid") String uid);

    @FormUrlEncoded
    @POST("poem/get_poem_detail")
    Call<PoemDetailData> getPoemDetail(@Field("userId") String userId,
                                       @Field("poemId") String poemId);
    @FormUrlEncoded
    @POST("misc/send_action")
    Call<ReactionData> GiveReaction(@Field("userId") String userId,
                                    @Field("catId") String catId,
                                    @Field("poemId") String poemId);
    @FormUrlEncoded
    @POST("poem/delete_poem")
    Call<PoemListData> DeletePoem (@Field("poemId") String poemId);

    @FormUrlEncoded
    @POST("poem/write_poem")
    Call<PoemWriteData> writePoem(@Field("userId") String userId,
                                  @Field("title") String title,
                                  @Field("content") String content,
                                  @Field("categoryId") String categoryId,
                                  @Field("published")String published);

    @FormUrlEncoded
    @POST("poem/write_poem")
    Call<PoemWriteData> editPoem(@Field("userId") String userId,
                                  @Field("title") String title,
                                  @Field("content") String content,
                                  @Field("categoryId") String categoryId,
                                  @Field("published")String published,
                                  @Field("poemId") String poemId);
}
