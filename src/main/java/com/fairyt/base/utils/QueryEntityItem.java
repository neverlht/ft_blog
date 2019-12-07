package com.fairyt.base.utils;

import java.util.List;

/**
 * 实体项
 */
public class QueryEntityItem {

    //主实体
    private Class entityClass;

    //别名
    private String alias;

    //on 条件
    private List<QueryItem> onConditions;

    public QueryEntityItem(Class entityClass, String alias) {
        this.entityClass = entityClass;
        this.alias = alias;
    }

    public QueryEntityItem(Class entityClass, String alias,QueryOn on) {
        this.entityClass = entityClass;
        this.alias = alias;
        this.onConditions = on.getConditions();
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public String getAlias() {
        return alias;
    }

    public List<QueryItem> getOnConditions() {
        return onConditions;
    }

}
