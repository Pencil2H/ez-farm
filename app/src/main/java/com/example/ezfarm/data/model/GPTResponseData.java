package com.example.ezfarm.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GPTResponseData {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("choices")
    @Expose
    private List<Choice> choices;
    @SerializedName("usage")
    @Expose
    private Usage usage;
    @SerializedName("error")
    @Expose
    private Error error;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public class Usage {

        @SerializedName("prompt_tokens")
        @Expose
        private Integer promptTokens;
        @SerializedName("completion_tokens")
        @Expose
        private Integer completionTokens;
        @SerializedName("total_tokens")
        @Expose
        private Integer totalTokens;

        public Integer getPromptTokens() {
            return promptTokens;
        }

        public void setPromptTokens(Integer promptTokens) {
            this.promptTokens = promptTokens;
        }

        public Integer getCompletionTokens() {
            return completionTokens;
        }

        public void setCompletionTokens(Integer completionTokens) {
            this.completionTokens = completionTokens;
        }

        public Integer getTotalTokens() {
            return totalTokens;
        }

        public void setTotalTokens(Integer totalTokens) {
            this.totalTokens = totalTokens;
        }

    }

    public class Choice {

        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("index")
        @Expose
        private Integer index;
        @SerializedName("logprobs")
        @Expose
        private Object logprobs;
        @SerializedName("finish_reason")
        @Expose
        private String finishReason;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Object getLogprobs() {
            return logprobs;
        }

        public void setLogprobs(Object logprobs) {
            this.logprobs = logprobs;
        }

        public String getFinishReason() {
            return finishReason;
        }

        public void setFinishReason(String finishReason) {
            this.finishReason = finishReason;
        }

    }

    public class Error {

        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("param")
        @Expose
        private Object param;
        @SerializedName("code")
        @Expose
        private String code;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getParam() {
            return param;
        }

        public void setParam(Object param) {
            this.param = param;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
