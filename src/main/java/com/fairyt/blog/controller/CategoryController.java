package com.fairyt.blog.controller;

import com.fairyt.base.utils.*;
import com.fairyt.blog.model.CategoryModel;
import com.fairyt.blog.service.CategoryService;
import com.fairyt.blog.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/category")
public class CategoryController extends BaseController<CategoryModel,CategoryService>{

    @Autowired
    private CategoryService service;

    @GetMapping("/del")
    public void del(){

    }

    @GetMapping("/info/{id}")
    public CategoryModel info(@PathVariable Long id){
        return service.findById(id);
    }

}
