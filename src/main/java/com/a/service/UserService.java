package com.a.service;

import com.a.entity.User;



public interface UserService {
    //查询用户所有信息 (Id)
    User FindById(int id);
}
