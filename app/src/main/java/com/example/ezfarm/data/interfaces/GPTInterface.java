package com.example.ezfarm.data.interfaces;

import com.example.poe_life.data.model.GPTRequestData;
import com.example.poe_life.data.model.GPTResponseData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GPTInterface {
    @POST("v1/completions")
    @Headers({
            "Authorization: Bearer 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",
            "Content-Type: application/json"
    })
    Call<GPTResponseData> completeText(@Body GPTRequestData body);
}
