package com.fairyt.base.utils;

/**
 * 实体项
 */
public class QueryEntityItem {

    //主实体
    private Class entityClass;

    //别名
    private String alias;

    //on 条件
    private QueryGroup onGroup;

    public QueryEntityItem(Class entityClass, String alias) {
        this.entityClass = entityClass;
        this.alias = alias;
    }
}
