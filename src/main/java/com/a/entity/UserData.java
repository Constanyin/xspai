package com.a.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author lyh666
 * 2019/10/5 16:27
 */
@Component
@Data
public class UserData {
    private Integer id;
    private String userName;
    private String sex;
    private String email;
    private String phone;


    public UserData() {
    }

    public UserData(Integer id, String userName, String sex, String email, String phone) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
    }

    public UserData(Integer id, String userName, String email, String phone) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
    }
}
