package com.fairyt.base.dao.provider;

import com.alibaba.fastjson.JSONObject;
import com.fairyt.base.utils.*;
import com.fairyt.blog.model.ArticleModel;
import com.fairyt.blog.model.CategoryModel;
import org.apache.commons.lang3.StringUtils;

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
        QueryEntity queryEntity = (QueryEntity) param.get("queryEntity");
        StringBuilder sb = new StringBuilder();
        sb.append(this.getSelectHeader(selects));
        sb.append(this.getSelectBody(modelClass,queryEntity));
        sb.append(this.getSelectCondition(queryGroup));
        String sql = sb.toString();
        return sql;
    }

    private String getSelectCondition(QueryGroup queryGroup) {
        String condition = QueryUtil.getGroupCondition(queryGroup);
        String result = " where 1=1 ";
        if(StringUtils.isNotBlank(condition)){
            result += " and "+condition;
        }
        return result;
    }

    private String getSelectBody(Class modelClass,QueryEntity queryEntity) {
        String mainTableName = "";
        if(queryEntity==null){
            Table table = (Table) modelClass.getAnnotation(Table.class);
            mainTableName = table.name();
        }else{
            QueryEntityItem  mainEntity  = queryEntity.getMainEntity();
            List<QueryEntityItem> slaveEntities = queryEntity.getSlaveEntity();
            Table mainTable = (Table)mainEntity.getEntityClass().getAnnotation(Table.class);
            mainTableName = mainTable.name();
            //处理别名
            String alias = mainEntity.getAlias();
            if(StringUtils.isNotBlank(alias)){
                mainTableName += " as "+alias;
            }

            //处理join条件
            if(slaveEntities!=null&&slaveEntities.size()>0){
                for(QueryEntityItem item:slaveEntities){
                    Table itemTable = (Table)mainEntity.getEntityClass().getAnnotation(Table.class);
                    String itemName = itemTable.name();
                    String itemAlias = item.getAlias();
                    QueryGroup onGroup = item.getOnGroup();
                    String joinStr = " left join "+itemName+" as "+itemAlias+"";
                }
            }

        }

        String result = " from "+mainTableName;
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

        QueryRequest request = QueryRequest
                .select("a.id,a.title,c.name")
                .from(ArticleModel.class,"a")
                .join(CategoryModel.class,"c",QueryGroup.singleGroup(QueryItem.build("c.code",QueryItem.Op.EQUAL,"a.cateCode")))
                .where(QueryGroup.andGroup(QueryItem.build("a.cateCode",QueryItem.Op.IS_NOT_NULL,"")));
        QueryGroup queryGroup = QueryGroup.singleGroup(QueryItem.build("c.code",QueryItem.Op.EQUAL,"a.cateCode"));
        String sql = QueryUtil.getGroupCondition(queryGroup);
        System.out.println(sql);
    }
}
