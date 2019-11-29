package com.fairyt.blog.model;

import com.fairyt.base.model.BaseModel;

import javax.persistence.Table;

@Table(name="ft_blog_article")
public class ArticleModel extends BaseModel {
    //标题
    private String title;
    //分类code
    private String cateCode;
    //点击量
    private Long rate;
    //点赞数
    private Long zan;
    //摘要
    private String summary;
    //内容
    private String text;
    //内容md
    private String textMd;

    public String getTextMd() {
        return textMd;
    }

    public void setTextMd(String textMd) {
        this.textMd = textMd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
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

    @Override
    public String getDefaultQueryItem() {
        return "title";
    }
}
