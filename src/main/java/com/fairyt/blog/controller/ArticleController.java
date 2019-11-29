package com.fairyt.blog.controller;

import com.fairyt.blog.model.ArticleModel;
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
    public Page<ArticleModel> page(String kw,String cateCode,Integer page,Integer pageSize){
        page=page==null?1:page;
        pageSize = pageSize==null?10:pageSize;
        PageRequest pageRequest = new PageRequest(page,pageSize);
        List<QueryItem> queryItems = new ArrayList<>();
        if(StringUtils.isNotBlank(cateCode)){
            queryItems.add(QueryItem.build("cate_code",QueryItem.Op.EQUAL,cateCode));
        }
        if(StringUtils.isNotBlank(kw)){
            queryItems.add(QueryItem.build("title",QueryItem.Op.LIKE,kw));
        }
        QueryGroup query = QueryGroup.andGroup(queryItems);
        pageRequest.setQueryGroup(query);
        return service.page(pageRequest);
    }

//    @GetMapping("/info/{id}")
//    public ArticleModel info(@PathVariable Long id){
//        return service.findById(id);
//    }

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
