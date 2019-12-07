package com.fairyt.base.utils;

import com.fairyt.base.exception.BaseError;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础查询entity
 */
public class QueryEntity {

    //主实体
    private QueryEntityItem mainEntity;

    private List<QueryEntityItem> slaveEntity = new ArrayList<>();


    public static QueryEntity from(Class mainEntity,String as){
        QueryEntity entity = new QueryEntity();
        QueryEntityItem queryEntityItem = new QueryEntityItem(mainEntity,as);
        entity.mainEntity = queryEntityItem;
        return entity;
    }

    public QueryEntity join(Class entity,String as,QueryOn on){
        if(mainEntity==null){
            throw new BaseError("main entity lost");
        }
        QueryEntityItem currentItem = new QueryEntityItem(entity,as,on);
        this.slaveEntity.add(currentItem);
        return this;
    }

    public QueryEntityItem getMainEntity() {
        return mainEntity;
    }

    public void setMainEntity(QueryEntityItem mainEntity) {
        this.mainEntity = mainEntity;
    }

    public List<QueryEntityItem> getSlaveEntity() {
        return slaveEntity;
    }

    public void setSlaveEntity(List<QueryEntityItem> slaveEntity) {
        this.slaveEntity = slaveEntity;
    }
}
