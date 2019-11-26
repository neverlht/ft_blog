package com.fairyt.base.utils;

import java.util.UUID;

/**
 * 基础查询item
 */
public class QueryItem {
    private String id;

    private String field;

    private String op;

    private Object value;

    public QueryItem(String field, String op, Object value) {
        this.id = field+"_"+UUID.randomUUID().toString();
        this.field = field;
        this.op = op;
        this.value = value;
    }

    public static QueryItem build(String field,String op,Object value){
        return new QueryItem(field,op,value);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public class Op{
        public final static String EQUAL = "=";
        public final static String NOT_EQUAL = "!=";
        public final static String IS_NULL = " is null";
        public final static String IS_NOT_NULL = "is not null";
        public final static String GT = ">";
        public final static String LT = "<";
        public final static String LIKE = "LIKE";
        public final static String LIKER = "LIKER";
        public final static String LIKEL = "LIKEL";
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
