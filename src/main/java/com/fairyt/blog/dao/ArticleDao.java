package com.fairyt.blog.dao;

import com.fairyt.base.dao.CommonDao;
import com.fairyt.blog.model.ArticleModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface ArticleDao extends CommonDao<ArticleModel> {

}
