package com.example.ezfarm.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookmarkGetData {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<GetBookmark> data;

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

    public List<GetBookmark> getData() {
        return data;
    }

    public void setData(List<GetBookmark> data) {
        this.data = data;
    }
    public static class GetBookmark {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("date_created")
        @Expose
        private String dateCreated;
        @SerializedName("love_count")
        @Expose
        private String loveCount;
        @SerializedName("empathy_count")
        @Expose
        private String empathyCount;
        @SerializedName("authorImage")
        @Expose
        private String authorImage;

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

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
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

        public String getAuthorImage() {
            return authorImage;
        }

        public void setAuthorImage(String authorImage) {
            this.authorImage = authorImage;
        }
    }
}
