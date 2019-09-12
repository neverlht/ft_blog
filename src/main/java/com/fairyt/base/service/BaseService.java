package com.fairyt.base.service;


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
    List<T> list();
    List<T> list(T t);
    List<T> list(QueryRequest request);
    Page<T> page(T t, Integer page);
    Page<T> page(T t,Integer page,Integer pageSize);
    Page<T> page(PageRequest request);
}
