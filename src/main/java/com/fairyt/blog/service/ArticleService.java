package com.fairyt.blog.service;

import com.fairyt.base.service.BaseService;
import com.fairyt.blog.model.ArticleModel;

import java.util.List;

public interface ArticleService extends BaseService<ArticleModel> {
    List<ArticleModel> demo();
}
