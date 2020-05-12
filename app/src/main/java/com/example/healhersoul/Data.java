package com.example.healhersoul;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("title")
    private String news_title;

    @SerializedName("description")
    private String news_description;

    @SerializedName("urlToImage")
    private String image_url;

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @SerializedName("content")
    private String content;

    public String getContent() {
        return content;
    }

    public String getNews_title() {
        return news_title;
    }

    public String getNews_description() {
        return news_description;
    }

    public String getImage_url() {
        return image_url;
    }
}
