package com.fairyt.blog.dao;

import com.fairyt.base.dao.CommonDao;
import com.fairyt.blog.model.CategoryModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryDao extends CommonDao<CategoryModel> {

}
