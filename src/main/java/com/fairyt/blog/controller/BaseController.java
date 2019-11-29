package com.fairyt.blog.controller;

import com.fairyt.base.model.BaseModel;
import com.fairyt.base.service.BaseService;
import com.fairyt.base.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BaseController<M extends BaseModel,T extends BaseService> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private T service;

    @GetMapping("/base/page")
    public Page<M> page(String kw, Integer page, Integer pageSize){
        page=page==null?1:page;
        pageSize = pageSize==null?10:pageSize;
        PageRequest pageRequest = new PageRequest(page,pageSize);
        List<QueryItem> queryItems = new ArrayList<>();
        if(StringUtils.isNotBlank(kw)){
            String queryField = this.getDefaultModelQueryField();
            if(StringUtils.isNotBlank(queryField)){
                queryItems.add(QueryItem.build(queryField,QueryItem.Op.LIKE,kw));
            }
        }
        QueryGroup query = QueryGroup.andGroup(queryItems);
        pageRequest.setQueryGroup(query);
        return service.page(pageRequest);
    }

    @GetMapping("/base/info/{id}")
    public M info(@PathVariable Long id){
        return (M) service.findById(id);
    }

    @PostMapping("/base/save")
    public M save(@RequestBody M model){
        return (M) service.saveOrUpdate(model);
    }

    @GetMapping("/base/list")
    public List<M> list(String kw){
        if(StringUtils.isNotBlank(kw)){
            QueryRequest request = new QueryRequest();
            QueryItem item = QueryItem.build(this.getDefaultModelQueryField(),QueryItem.Op.LIKE,kw);
            request.setQueryGroup(QueryGroup.singleGroup(item));
            service.list(request);
        }
        return service.list();
    }

    private String getDefaultModelQueryField() {
        Type[] types = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments();
        if(types!=null&&types.length>0){
            Type modelType = types[0];
            Class modelClass = (Class) modelType;
            try {
                Object instance = ((Class)modelType).newInstance();
                Method method = modelClass.getMethod("getDefaultQueryItem");
                String defaultQueryField = (String) method.invoke(instance);
                return defaultQueryField;
            } catch (Exception e) {
                logger.error("get default query field error",e);
                return null;
            }
        }
        return null;
    }
}
