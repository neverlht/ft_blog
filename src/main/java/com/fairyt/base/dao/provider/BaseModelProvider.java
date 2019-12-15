package com.fairyt.base.dao.provider;

import com.alibaba.fastjson.JSONObject;
import com.fairyt.base.utils.*;
import com.fairyt.blog.model.ArticleModel;
import com.fairyt.blog.model.CategoryModel;
import java.util.*;

public class BaseModelProvider {

    public String findDemo(Map<String,Object> param){
        JSONObject obj = (JSONObject) param.get("test");
        System.out.println(obj.toJSONString());
        String sql = "select * from b_article where author = #{test.id}";
        return sql;
    }



    public String findListByRequest(Map<String,Object> param){
        QueryRequest queryRequest = (QueryRequest) param.get("queryRequest");
        Class modelClass = (Class) param.get("modelClass");
        String sql = QueryUtil.getSql(queryRequest,modelClass);
        return sql;
    }


    public String findJsonListByRequest(Map<String,Object> param){
        QueryRequest queryRequest = (QueryRequest) param.get("queryRequest");

        String sql = QueryUtil.getSql(queryRequest,null);

        return sql;
    }


    public static void main(String[] arg){

        QueryRequest request = QueryRequest
                .select("a.id,a.title,c.name")
                .from(ArticleModel.class,"a")
                .join(CategoryModel.class,"c",QueryOn.build(QueryItem.build("c.code",QueryItem.Op.EQUAL,"a.cateCode")))
                .where(QueryGroup.andGroup(QueryItem.build("a.cateCode",QueryItem.Op.IS_NOT_NULL,"")));
        System.out.println(QueryUtil.getSql(request,null));
    }
}
