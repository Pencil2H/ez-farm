package com.example.ezfarm.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommentGetData {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Commentdata> data;

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

    public List<Commentdata> getData() {
        return data;
    }

    public void setData(List<Commentdata> data) {

        this.data = data;
    }
    public static class Commentdata {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("comment")
        @Expose
        private String comment;
        @SerializedName("userId")
        @Expose
        private String userId;
        @SerializedName("userName")
        @Expose
        private String userName;
        @SerializedName("dateCreated")
        @Expose
        private String dateCreated;
        @SerializedName("userImage")
        @Expose
        private String userImage;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

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

        public String getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
        }

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

    }
}
