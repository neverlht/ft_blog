package com.fairyt.base.model;

import javax.persistence.Table;

@Table(name="ft_blog_article")
public class ArticleModel extends BaseModel{
    //标题
    private String title;
    //分类id
    private Long cate_id;
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

    public Long getCate_id() {
        return cate_id;
    }

    public void setCate_id(Long cate_id) {
        this.cate_id = cate_id;
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
