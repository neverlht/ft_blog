package com.fairyt.blog.controller;

import com.fairyt.base.utils.*;
import com.fairyt.blog.model.CategoryModel;
import com.fairyt.blog.service.CategoryService;
import com.fairyt.blog.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/page")
    public Page<CategoryModel> page(Integer page, Integer pageSize){
        page=page==null?1:page;
        pageSize = pageSize==null?10:pageSize;
        PageRequest pageRequest = new PageRequest(page,pageSize);
        return service.page(pageRequest);
    }

    @GetMapping("/del")
    public void del(){

    }

    @GetMapping("/info/{id}")
    public CategoryModel info(@PathVariable Long id){
        return service.findById(id);
    }

}
