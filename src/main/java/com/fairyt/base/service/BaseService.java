package com.fairyt.base.service;


import com.alibaba.fastjson.JSONObject;
import com.fairyt.base.model.BaseModel;
import com.fairyt.base.utils.Page;
import com.fairyt.base.utils.PageRequest;
import com.fairyt.base.utils.QueryRequest;

import java.util.List;

public interface BaseService<T extends BaseModel> {
    T saveOrUpdate(T t);
    int delete(Long id);
    T findById(Long id);
    T saveOrUpdateSelective(T t);
    T findOne(T t);
    T findOne(QueryRequest request);
    List<T> list();
    List<T> list(T t);
    List<T> list(QueryRequest request);
    Page<T> page(T t, Integer page);
    Page<T> page(T t,Integer page,Integer pageSize);
    Page<T> page(PageRequest request);
    List<JSONObject> listJson(QueryRequest request);
    Page<JSONObject> pageJson(PageRequest request);
}
