package com.fairyt.base.dao.provider;

import com.alibaba.fastjson.JSONObject;
import com.fairyt.blog.model.ArticleModel;
import com.fairyt.base.utils.QueryGroup;
import com.fairyt.base.utils.QueryUtil;

import javax.persistence.Table;
import java.util.*;

public class BaseModelProvider {

    public String findDemo(Map<String,Object> param){
        JSONObject obj = (JSONObject) param.get("test");
        System.out.println(obj.toJSONString());
        String sql = "select * from b_article where author = #{test.id}";
        return sql;
    }

    public String findListByRequest(Map<String,Object> param){
        QueryGroup queryGroup = (QueryGroup) param.get("queryGroup");
        Class modelClass = (Class) param.get("modelClass");
        Set<String> selects = (Set<String>) param.get("selects");
        StringBuilder sb = new StringBuilder();
        sb.append(this.getSelectHeader(selects));
        sb.append(this.getSelectBody(modelClass));
        sb.append(this.getSelectCondition(queryGroup));
        String sql = sb.toString();
        return sql;
    }

    private String getSelectCondition(QueryGroup queryGroup) {
        String result = " where 1=1 and "+QueryUtil.getGroupCondition(queryGroup);
        return result;
    }

    private String getSelectBody(Class modelClass) {
        Table table = (Table) modelClass.getAnnotation(Table.class);
        String result = " from "+table.name();
        return result;
    }

    private String getSelectHeader(Set<String> selects) {
        String result = "select ";
        if(selects!=null&&selects.size()>0){
            String[] sts = new String[selects.size()];
            selects.toArray(sts);
            for(int i=0;i<sts.length;i++){
                if(i>0){
                    result+=",";
                }
                result += " "+sts[i]+" ";
            }
        }else{
            result += " * ";
        }
        return result;
    }


    public static void main(String[] arg){
        Class clazz = ArticleModel.class;
        Table table = (Table) clazz.getAnnotation(Table.class);
        System.out.println(table.name());
    }
}
