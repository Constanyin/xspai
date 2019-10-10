package com.a.service.Impl;

import com.a.entity.User;
import com.a.mapper.IUserMapper;
import com.a.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author liuxin
 * @Date 2019.10.09.0009 14:12
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private IUserMapper userMapper;

    @Override
    public User FindById(int id) {
        User user = userMapper.FindById(id);
        return user;
    }
}
