package com.a.controller;

import com.a.mapper.IUserShowMapper;
import com.a.service.IUserShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author lyh666
 * 2019/9/30 15:43
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
@Resource
    private IUserShowService userShowService;
@RequestMapping(value = "show",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String ShowUser(){
    return "1";
}
}
