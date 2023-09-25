package com.example.ezfarm.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesData {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<categories> data;

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

    public List<categories> getData() {
        return data;
    }

    public void setData(List<categories> data) {
        this.data = data;
    }

    public class categories {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("categoryName")
        @Expose
        private String categoryName;
        @SerializedName("categoryColor")
        @Expose
        private String categoryColor;
        @SerializedName("categoryImage")
        @Expose
        private String categoryImage;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryColor() {
            return categoryColor;
        }

        public void setCategoryColor(String categoryColor) {
            this.categoryColor = categoryColor;
        }

        public String getCategoryImage() {
            return categoryImage;
        }

        public void setCategoryImage(String categoryImage) {
            this.categoryImage = categoryImage;
        }
    }
}
