package com.example.ezfarm.data.interfaces;

import com.example.poe_life.data.model.CategoriesData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MiscInterface {
    @GET("misc/get_poem_category")
    Call<CategoriesData> getcategories(@Query("t") String catid);
}
