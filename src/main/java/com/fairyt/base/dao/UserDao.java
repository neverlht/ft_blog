package com.fairyt.base.dao;

import com.fairyt.base.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao extends CommonDao<UserModel>{
}
