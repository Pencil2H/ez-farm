package com.example.ezfarm.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private UserData data;

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

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public static class  UserData{

        @SerializedName("userId")
        @Expose
        private String userId;
        @SerializedName("userName")
        @Expose
        private String userName;
        @SerializedName("userEmail")
        @Expose
        private String userEmail;
        @SerializedName("userImage")
        @Expose
        private String userImage;
        @SerializedName("loginToken")
        @Expose
        private String loginToken;

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

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getLoginToken() {
            return loginToken;
        }

        public void setLoginToken(String loginToken) {
            this.loginToken = loginToken;
        }

    }
        
}


