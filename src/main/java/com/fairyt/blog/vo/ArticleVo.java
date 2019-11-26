package com.fairyt.blog.vo;

import com.fairyt.blog.model.ArticleModel;

import java.util.List;


public class ArticleVo extends ArticleModel {
    List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
