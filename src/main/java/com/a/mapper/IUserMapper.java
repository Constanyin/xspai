package com.a.mapper;

import com.a.entity.User;
import org.apache.ibatis.annotations.Param;

public interface IUserMapper {
    //查询用户对象
    User FindById(@Param("uid")int id);
}
