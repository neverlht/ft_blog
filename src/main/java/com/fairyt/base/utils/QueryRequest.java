package com.fairyt.base.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QueryRequest{

    private Set<String> queryFields = new HashSet<>();

    private QueryGroup queryGroup;

    private QueryEntity queryEntity;

    public QueryRequest() {

    }

    public QueryRequest(QueryGroup queryGroup){
        this.queryGroup = queryGroup;
    }

    public QueryGroup getQueryGroup() {
        return queryGroup;
    }

    public void setQueryGroup(QueryGroup queryGroup) {
        this.queryGroup = queryGroup;
    }

    public QueryEntity getQueryEntity() {
        return queryEntity;
    }

    public void setQueryEntity(QueryEntity queryEntity) {
        this.queryEntity = queryEntity;
    }

    public Set<String> getQueryFields() {
        return queryFields;
    }

    public void setQueryFields(Set<String> queryFields) {
        this.queryFields = queryFields;
    }

    public static QueryRequest selectAll(){
        QueryRequest request = new QueryRequest();
        return request;
    }

    public QueryRequest selectFields(String field){
        addFields(field,this.queryFields);
        return this;
    }

    private static void addFields(String field,Set<String> list){
        if(field.contains(",")){
            String[] fields = field.split(",");
            for(String f:fields){
                list.add(f);
            }
        }else{
            list.add(field);
        }
    }

    public static QueryRequest select(String field){
        QueryRequest request = new QueryRequest();
        Set<String> list = new HashSet<>();
        addFields(field,list);
        request.setQueryFields(list);
        return request;
    }

    public QueryRequest from(Class mainEntity,String as){
        this.setQueryEntity(QueryEntity.from(mainEntity,as));
        return this;
    }

    public QueryRequest join(Class mainEntity,String as,QueryOn on){
        this.getQueryEntity().join(mainEntity,as,on);
        return this;
    }

    public QueryRequest where(QueryGroup queryGroup){
        this.setQueryGroup(queryGroup);
        return this;
    }

    public PageRequest page(Integer page){
        return page(page,10);
    }

    public PageRequest page(Integer page,Integer pageSize){
        PageRequest pageRequest = new PageRequest(page,pageSize);
        pageRequest.setQueryGroup(this.getQueryGroup());
        pageRequest.setQueryFields(this.getQueryFields());
        pageRequest.setQueryEntity(this.getQueryEntity());
        return pageRequest;
    }

}
