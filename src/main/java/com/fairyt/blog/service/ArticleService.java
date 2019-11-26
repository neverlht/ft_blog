package com.fairyt.blog.service;

import com.fairyt.base.service.BaseService;
import com.fairyt.blog.model.ArticleModel;
import com.fairyt.blog.vo.ArticleVo;

import java.util.List;

public interface ArticleService extends BaseService<ArticleModel> {
    List<ArticleModel> demo();

    ArticleModel saveArticle(ArticleVo article);
}
