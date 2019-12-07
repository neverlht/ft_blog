package com.fairyt.base.utils;


import com.alibaba.fastjson.JSONObject;
import com.fairyt.base.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class QueryUtil {

    /**
     * 获取sql请求的params
     * @param queryGroup
     * @return
     */
    public static JSONObject getQueryParams(QueryGroup queryGroup){
        JSONObject result = new JSONObject();
        List<QueryGroup> groups = queryGroup.getGroups();
        List<QueryItem> items = queryGroup.getItems();
        for(QueryItem item:items){
            Object currentValue = item.getValue();
//            //处理like
//            if(item.getOp().equals(QueryItem.Op.LIKE)){
//                currentValue = "%"+currentValue+"%";
//            }
//            if(item.getOp().equals(QueryItem.Op.LIKER)){
//                currentValue = currentValue+"%";
//            }
//            if(item.getOp().equals(QueryItem.Op.LIKEL)){
//                currentValue = "%"+currentValue;
//            }
            result.put(item.getId(),currentValue);
        }
        for(QueryGroup group:groups){
            result.putAll(getQueryParams(group));
        }
        return result;
    }


    /**
     * 获取group请求的条件
     * @param queryGroup
     * @return
     */
    public static String getGroupCondition(QueryGroup queryGroup){

        String result = "";
        for(int i=0;i<queryGroup.getItems().size();i++){
            if(i==0)
                result+="( ";
            QueryItem item = queryGroup.getItems().get(i);
            if(i>0)
                result+=" "+queryGroup.getItemsOp()+" ";
            String afterOp = "";
            String currentOp = item.getOp();
            if(!currentOp.equals(QueryItem.Op.IS_NULL)&&!currentOp.equals(QueryItem.Op.IS_NOT_NULL)){
                afterOp = "#{params."+item.getId()+"}";
            }
            if(currentOp.equals(QueryItem.Op.LIKE)
                    ||currentOp.equals(QueryItem.Op.LIKER)
                    ||currentOp.equals(QueryItem.Op.LIKEL)){
                if(currentOp.equals(QueryItem.Op.LIKE)){
                    afterOp = "concat(concat('%',#{params."+item.getId()+"}),'%')";
                }
                if(currentOp.equals(QueryItem.Op.LIKER)){
                    afterOp = "#{params."+item.getId()+"}'%'";
                }
                if(currentOp.equals(QueryItem.Op.LIKEL)){
                    afterOp = "'%'#{params."+item.getId()+"}";
                }
                currentOp = QueryItem.Op.LIKE;
            }
            result += item.getField()+" "+currentOp+" "+afterOp;
        }
        if(StringUtils.isNotBlank(result))
            result+=" ) ";
        if(queryGroup.getGroups()!=null&&queryGroup.getGroups().size()>0){
            result +=" "+queryGroup.getProNodeOp()+" ";
            for(int i=0;i<queryGroup.getGroups().size();i++){
                QueryGroup currentGroup = queryGroup.getGroups().get(i);
                if(i>0){
                    result+=" "+currentGroup.getProNodeOp()+" ";
                }
                result+=" "+getGroupCondition(currentGroup)+" ";
            }
        }
        return result;
    }

    /**
     * 获取on的条件
     * @param conditions
     * @return
     */
    public static String getOnCondition(List<QueryItem> conditions){
        String result = "";
        for(QueryItem item:conditions){
            // todo
            result +=item.getField()+" "+item.getOp();

        }

        return "";
    }

    public static Class getCurrentQueryClass(Class c) {
        Type clazz = c.getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)clazz;
        Class modelClass = (Class) pt.getActualTypeArguments()[0];
        return modelClass;
    }
}
