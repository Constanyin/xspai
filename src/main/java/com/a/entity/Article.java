package com.a.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author liuxin
 * @Date 2019.09.30.0030 14:48
 **/
@Component
@Data
public class Article {
    private Integer id;
    private String name;
    private String headPic;
    private String article;
    private String createTime;
    private Integer loves;
    private Integer userId;
    private String columnName;
    private String isDelete;
    private User user;
}
