package com.fairyt.base.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础查询Group
 */
public class QueryGroup {

    public final static String AND="AND";
    public final static String OR="OR";
    public final static String SINGLE="SINGLE";

    private List<QueryItem> items = new ArrayList<>();

    private List<QueryGroup> groups = new ArrayList<>();

    private String proNodeOp = null;

    private String itemsOp = null;

    public List<QueryItem> getItems() {
        return items;
    }

    public void setItems(List<QueryItem> items) {
        this.items = items;
    }

    public List<QueryGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<QueryGroup> groups) {
        this.groups = groups;
    }

    public String getProNodeOp() {
        return proNodeOp;
    }

    public void setProNodeOp(String proNodeOp) {
        this.proNodeOp = proNodeOp;
    }

    public String getItemsOp() {
        return itemsOp;
    }

    public void setItemsOp(String itemsOp) {
        this.itemsOp = itemsOp;
    }

    public QueryGroup(String op, List<QueryItem> items){
        this.itemsOp = op;
        this.items = items;
    }

    public QueryGroup(String op, QueryItem... items){
        this.itemsOp = op;
        for(QueryItem item:items){
            this.items.add(item);
        }
    }

    public static QueryGroup andGroup(QueryItem... items){
        QueryGroup group = new QueryGroup(AND,items);
        return group;
    }

    public static QueryGroup andGroup(List<QueryItem> items){
        QueryGroup group = new QueryGroup(AND,items);
        return group;
    }

    public static QueryGroup orGroup(List<QueryItem> items){
        QueryGroup group = new QueryGroup(OR,items);
        return group;
    }

    public static QueryGroup orGroup(QueryItem... items){
        QueryGroup group = new QueryGroup(OR,items);
        return group;
    }

    public static QueryGroup singleGroup(QueryItem item) {
        QueryGroup group = new QueryGroup(SINGLE,item);
        return group;
    }

    public QueryGroup and(QueryGroup... groups) {
        this.proNodeOp = AND;
        for(QueryGroup group:groups){
            group.proNodeOp = AND;
            this.groups.add(group);
        }
        return this;
    }

    public QueryGroup or(QueryGroup... groups) {
        for(QueryGroup group:groups){
            group.proNodeOp = OR;
            this.groups.add(group);
        }
        return this;
    }

    public static void main(String[] args){
        QueryItem item1 = new QueryItem("name",QueryItem.Op.EQUAL,"admin");
        QueryItem item11 = new QueryItem("name",QueryItem.Op.EQUAL,"lht");
        QueryItem item2 = new QueryItem("age",QueryItem.Op.GT,"13");
        QueryItem item3 = new QueryItem("sex",QueryItem.Op.IS_NOT_NULL,"");
        QueryItem item4 = new QueryItem("height",QueryItem.Op.GT,"160");
        QueryItem item41 = new QueryItem("height",QueryItem.Op.LT,"180");
        QueryItem itemOr = new QueryItem("both",QueryItem.Op.EQUAL,true);
//        QueryGroup group = QueryGroup.orGroup(item1,item11)
//                .and(QueryGroup.singleGroup(item2),QueryGroup.andGroup(item4,item41),QueryGroup.singleGroup(item3))
//                .or(QueryGroup.singleGroup(itemOr));

        QueryGroup group = QueryGroup.orGroup(item1,item11)
                .and(QueryGroup.andGroup(item2,item4,item41,item3))
                .or(QueryGroup.singleGroup(itemOr));
        System.out.println(QueryUtil.getGroupCondition(group));
        System.out.println(QueryUtil.getQueryParams(group).toJSONString());
    }



}
