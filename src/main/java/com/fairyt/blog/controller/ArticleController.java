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
public class ArticleController {

    @Autowired
    private ArticleService service;

    @GetMapping("/list")
    public List<ArticleModel> list(){
        return service.list();
    }

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

    @GetMapping("/request")
    public List<ArticleModel> request(){
        QueryRequest queryRequest = new QueryRequest();
        QueryGroup group = QueryGroup.andGroup(QueryItem.build("id", QueryItem.Op.GT,5),
                QueryItem.build("id", QueryItem.Op.LT,10),
                QueryItem.build("summary", QueryItem.Op.IS_NOT_NULL,""));
        queryRequest.setQueryGroup(group);
        return service.list(queryRequest);
    }

    @GetMapping("/requestPage")
    public Page<ArticleModel> requestPage(){
        QueryGroup group = QueryGroup.andGroup(QueryItem.build("id", QueryItem.Op.GT,5),
                QueryItem.build("id", QueryItem.Op.LT,10),
                QueryItem.build("summary", QueryItem.Op.IS_NOT_NULL,""));
        PageRequest pageRequest = new PageRequest(2,2);
        pageRequest.setQueryGroup(group);
        return service.page(pageRequest);
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
