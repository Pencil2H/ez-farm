package com.example.ezfarm.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GPTRequestData {

    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("prompt")
    @Expose
    private String prompt;
    @SerializedName("max_tokens")
    @Expose
    private Integer maxTokens;
    @SerializedName("temperature")
    @Expose
    private double temperature;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
