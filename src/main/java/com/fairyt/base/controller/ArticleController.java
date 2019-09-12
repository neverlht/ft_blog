package com.fairyt.base.controller;

import com.fairyt.base.model.ArticleModel;
import com.fairyt.base.model.DemoModel;
import com.fairyt.base.service.ArticleService;
import com.fairyt.base.service.DemoService;
import com.fairyt.base.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Page<ArticleModel> page(){
        return service.page(null,1);
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
}
