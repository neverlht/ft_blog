package com.fairyt.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fairyt.base.dao.BaseDao;
import com.fairyt.base.dao.CommonDao;
import com.fairyt.base.model.BaseModel;
import com.fairyt.base.service.BaseService;
import com.fairyt.base.utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {
    @Autowired
    private CommonDao<T> dao;

    @Override
    public T saveOrUpdate(T t) {
        t.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        if(t.getId()==null){
            t.setCreateTime(new Timestamp(System.currentTimeMillis()));
            dao.insert(t);
            return t;
        }else{
            dao.updateByPrimaryKey(t);
            return t;
        }
    }

    @Override
    public T saveOrUpdateSelective(T t) {
        t.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        if (t.getId() == null) {
            t.setCreateTime(new Timestamp(System.currentTimeMillis()));
            dao.insertSelective(t);
            return t;
        }else {
            dao.updateByPrimaryKeySelective(t);
            return t;
        }
    }

    @Override
    public T findOne(T t) {
        List<T> resultList = this.list(t);
        if(resultList!=null&&resultList.size()>0)
            return resultList.get(0);
        return null;
    }

    @Override
    public T findOne(QueryRequest request) {
        List<T> resultList = this.list(request);
        if(resultList!=null&&resultList.size()>0)
            return resultList.get(0);
        return null;
    }

    @Override
    public List<T> list() {
        return dao.selectAll();
    }

    @Override
    public List<T> list(T t) {
        return dao.select(t);
    }

    @Override
    public List<T> list(QueryRequest request) {
        QueryGroup queryGroup = request.getQueryGroup();
        Set<String> selects = request.getQueryFields();
        Class modelClass = QueryUtil.getCurrentQueryClass(this.getClass());
        QueryEntity queryEntity = request.getQueryEntity();
        JSONObject params = QueryUtil.getQueryParams(queryGroup);
//        Type clazz = this.getClass().getGenericSuperclass();
//        ParameterizedType pt = (ParameterizedType)clazz;
//        Class modelClass = (Class) pt.getActualTypeArguments()[0];
        return dao.findListByRequest(queryGroup,modelClass,selects,queryEntity,params);
    }

    @Override
    public Page<T> page(T t, Integer page) {
        return this.page(t,page,10);
    }

    @Override
    public Page<T> page(T t, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize,true);
        List<T> resultList;
        if(t!=null){
            resultList = this.list(t);
        }else{
            resultList = this.list();
        }
        PageInfo<T> pageInfo = new PageInfo<>(resultList);
        return  new Page<>(pageInfo);
    }

    @Override
    public Page<T> page(PageRequest request) {
        PageHelper.startPage(request.getPage(),request.getPageSize(),true);
        List<T> resultList = this.list(request);
        PageInfo<T> pageInfo = new PageInfo<>(resultList);
        return  new Page<>(pageInfo);
    }

    public int delete(Long id){
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public T findById(Long id) {
        return dao.selectByPrimaryKey(id);
    }
}
