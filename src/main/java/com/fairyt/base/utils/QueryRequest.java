package com.fairyt.base.utils;

import java.util.HashSet;
import java.util.Set;

public class QueryRequest{

    private Set<String> queryFields = new HashSet<>();

    private QueryGroup queryGroup;

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

    public Set<String> getQueryFields() {
        return queryFields;
    }

    public void setQueryFields(Set<String> queryFields) {
        this.queryFields = queryFields;
    }

    public void addField(String field){
        Set<String> addFields = new HashSet<>();
        if(field.contains(",")){
            String[] fields = field.split(",");
            for(String f:fields){
                addFields.add(f);
            }
        }else{
            addFields.add(field);
        }
        this.queryFields.addAll(addFields);
    }
}
