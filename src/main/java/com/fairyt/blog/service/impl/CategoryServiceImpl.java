package com.fairyt.blog.service.impl;

import com.fairyt.base.service.impl.BaseServiceImpl;
import com.fairyt.blog.dao.CategoryDao;
import com.fairyt.blog.model.CategoryModel;
import com.fairyt.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryModel> implements CategoryService {

    @Autowired
    private CategoryDao dao;

}