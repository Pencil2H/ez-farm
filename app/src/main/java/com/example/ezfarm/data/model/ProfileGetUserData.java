package com.example.ezfarm.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileGetUserData {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public class Data {

        @SerializedName("userId")
        @Expose
        private String userId;
        @SerializedName("userName")
        @Expose
        private String userName;
        @SerializedName("userImage")
        @Expose
        private String userImage;
        @SerializedName("following")
        @Expose
        private String following;
        @SerializedName("follower")
        @Expose
        private String follower;
        @SerializedName("isFollowing")
        @Expose
        private String isFollowing;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getFollowing() {
            return following;
        }

        public void setFollowing(String following) {
            this.following = following;
        }

        public String getFollower() {
            return follower;
        }

        public void setFollower(String follower) {
            this.follower = follower;
        }

        public String getIsFollowing() {
            return isFollowing;
        }

        public void setIsFollowing(String isFollowing) {
            this.isFollowing = isFollowing;
        }

    }
}
