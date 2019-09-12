package com.fairyt.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fairyt.base.dao.ArticleDao;
import com.fairyt.base.dao.BaseDao;
import com.fairyt.base.model.ArticleModel;
import com.fairyt.base.model.DemoModel;
import com.fairyt.base.service.ArticleService;
import com.fairyt.base.service.DemoService;
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
}
