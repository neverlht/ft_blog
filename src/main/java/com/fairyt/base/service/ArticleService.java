package com.fairyt.base.service;

import com.fairyt.base.model.ArticleModel;

import java.util.List;

public interface ArticleService extends BaseService<ArticleModel>{
    List<ArticleModel> demo();
}
