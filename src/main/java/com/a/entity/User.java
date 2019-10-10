package com.a.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author liuxin
 * @Date 2019.10.09.0009 13:53
 **/
@Data
@Component
public class User {
    private Integer id;
    private String uUsername;
    private String uPassword;
    private String uSex;
    private String uEmail;
    private String uPhone;
    private String isDelete;
    private String uHead;

}
