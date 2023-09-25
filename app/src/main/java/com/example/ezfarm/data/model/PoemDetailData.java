package com.example.ezfarm.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PoemDetailData {

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
    public static class Data {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("content")
        @Expose
        private String content;
        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("authorId")
        @Expose
        private String authorId;
        @SerializedName("categoryId")
        @Expose
        private String categoryId;
        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("isBookmark")
        @Expose
        private String isBookmark;
        @SerializedName("love_count")
        @Expose
        private String loveCount;
        @SerializedName("empathy_count")
        @Expose
        private String empathyCount;
        @SerializedName("has_love_reaction")
        @Expose
        private String hasLoveReaction;
        @SerializedName("has_empathy_reaction")
        @Expose
        private String hasEmpathyReaction;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthorId() {
            return authorId;
        }

        public void setAuthorId(String authorId) {
            this.authorId = authorId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getIsBookmark() {
            return isBookmark;
        }

        public void setIsBookmark(String isBookmark) {
            this.isBookmark = isBookmark;
        }

        public String getLoveCount() {
            return loveCount;
        }

        public void setLoveCount(String loveCount) {
            this.loveCount = loveCount;
        }

        public String getEmpathyCount() {
            return empathyCount;
        }

        public void setEmpathyCount(String empathyCount) {
            this.empathyCount = empathyCount;
        }

        public String getHasLoveReaction() {
            return hasLoveReaction;
        }

        public void setHasLoveReaction(String hasLoveReaction) {
            this.hasLoveReaction = hasLoveReaction;
        }

        public String getHasEmpathyReaction() {
            return hasEmpathyReaction;
        }

        public void setHasEmpathyReaction(String hasEmpathyReaction) {
            this.hasEmpathyReaction = hasEmpathyReaction;
        }
    }
}


