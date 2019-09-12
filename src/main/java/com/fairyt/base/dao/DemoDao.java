package com.fairyt.base.dao;

import com.fairyt.base.model.DemoModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DemoDao extends CommonDao<DemoModel>{
}
