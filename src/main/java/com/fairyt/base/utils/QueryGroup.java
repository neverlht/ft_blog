package com.fairyt.base.utils;

import com.fairyt.blog.model.ArticleModel;
import com.fairyt.blog.model.CategoryModel;

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

        QueryRequest request = QueryRequest
//                .select("a.id,a.title").selectFields("c.name")
                .select("a.id,a.title,c.name")
                .from(ArticleModel.class,"a")
                .join(CategoryModel.class,"c",QueryOn.build(QueryItem.build("c.code",QueryItem.Op.EQUAL,"a.cateCode")))
                .where(QueryGroup.andGroup(QueryItem.build("a.cateCode",QueryItem.Op.IS_NOT_NULL,"")));
    }



}
