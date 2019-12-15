package com.fairyt.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.fairyt.blog.model.ArticleModel;
import com.fairyt.blog.model.CategoryModel;
import com.fairyt.blog.service.ArticleService;
import com.fairyt.base.utils.*;
import com.fairyt.blog.vo.ArticleVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController extends BaseController<ArticleModel,ArticleService>{

    @Autowired
    private ArticleService service;

    @GetMapping("/page")
    public Page<JSONObject> page(String kw, String cateCode, Integer page, Integer pageSize){
        page=page==null?1:page;
        pageSize = pageSize==null?10:pageSize;
        List<QueryItem> queryItems = new ArrayList<>();
        if(StringUtils.isNotBlank(cateCode)){
            queryItems.add(QueryItem.build("cate_code",QueryItem.Op.EQUAL,cateCode));
        }
        if(StringUtils.isNotBlank(kw)){
            queryItems.add(QueryItem.build("title",QueryItem.Op.LIKE,kw));
        }
        QueryGroup query = QueryGroup.andGroup(queryItems);
        QueryRequest request = QueryRequest.select("a.title,c.name as cateName,a.summary,a.zan,a.rate,a.id,c.code")
                .from(ArticleModel.class,"a")
                .join(CategoryModel.class,"c",QueryOn.build(
                        QueryItem.build("a.cate_code",QueryItem.Op.EQUAL,"c.code")))
                .where(query);
        PageRequest pageRequest = request.page(page,pageSize);
        return service.pageJson(pageRequest);
    }

    /**
     * 保存文章接口
     * @param article
     * @return
     */
    @PostMapping("/save")
    public ArticleModel save(@RequestBody ArticleVo article){
        //1、处理标签 todo
        //2、保存文章
        return service.saveArticle(article);
    }
}
