package com.a.service.Impl;

import com.a.mapper.IUserShowMapper;
import com.a.service.IUserShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lyh666
 * 2019/10/3 16:40
 */
@Service("userService")
public class UserShowServiceImpl implements IUserShowService {
    @Resource
    private IUserShowMapper userShowMapper;
}
