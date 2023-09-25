package com.example.ezfarm.view.additional;

public class modelcardview {
    private String emotion;
    private int imgemotion;

    public modelcardview(String emotion, int imgemotion) {
        this.emotion = emotion;
        this.imgemotion = imgemotion;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public int getImgemotion() {
        return imgemotion;
    }

    public void setImgemotion(int imgemotion) {
        this.imgemotion = imgemotion;
    }
}