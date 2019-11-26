package com.fairyt.blog.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fairyt.blog.dao.ArticleDao;
import com.fairyt.base.service.impl.BaseServiceImpl;
import com.fairyt.blog.model.ArticleModel;
import com.fairyt.blog.service.ArticleService;
import com.fairyt.blog.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<ArticleModel> implements ArticleService {

    @Autowired
    private ArticleDao dao;

    @Override
    public List<ArticleModel> demo() {
        JSONObject obj = new JSONObject();
        obj.put("id","admin");
        return dao.findDemo(obj);
    }

    @Override
    public ArticleModel saveArticle(ArticleVo article) {
        //1、处理tags
        this.saveTags(article);
        return this.saveOrUpdate(article);
    }

    private void saveTags(ArticleVo article) {
        //todo
    }
}
