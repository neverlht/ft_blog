package com.fairyt.blog.model;

import com.fairyt.base.model.BaseModel;

import javax.persistence.Table;

@Table(name="ft_blog_article")
public class ArticleModel extends BaseModel {
    //标题
    private String title;
    //分类id
    private Long cateId;
    //点击量
    private Long rate;
    //点赞数
    private Long zan;
    //摘要
    private String summary;
    //内容
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Long getZan() {
        return zan;
    }

    public void setZan(Long zan) {
        this.zan = zan;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
