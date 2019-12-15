package com.fairyt.base.dao;

import com.alibaba.fastjson.JSONObject;
import com.fairyt.base.dao.provider.BaseModelProvider;
import com.fairyt.base.utils.QueryEntity;
import com.fairyt.base.utils.QueryGroup;
import com.fairyt.base.utils.QueryRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CommonDao<T> extends BaseDao<T> {

    @SelectProvider(type = BaseModelProvider.class, method = "findListByRequest")
    List<T> findListByRequest(@Param("queryRequest") QueryRequest queryRequest
            , @Param("modelClass") Class modelClass
            , @Param("params") JSONObject params);

    @SelectProvider(type = BaseModelProvider.class, method = "findJsonListByRequest")
    List<JSONObject> findJsonListByRequest(@Param("queryRequest") QueryRequest request,@Param("params")JSONObject params);
}
