package com.fairyt.blog.dao;

import com.alibaba.fastjson.JSONObject;
import com.fairyt.base.dao.CommonDao;
import com.fairyt.base.dao.provider.BaseModelProvider;
import com.fairyt.blog.model.ArticleModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleDao extends CommonDao<ArticleModel> {

    @SelectProvider(type = BaseModelProvider.class, method = "findDemo")
    List<ArticleModel> findDemo(@Param("test")JSONObject test);
}
