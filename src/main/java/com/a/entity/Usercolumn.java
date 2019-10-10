package com.a.entity;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @author lyh666
 * 2019/10/7 14:11
 */
@Component
@Data
public class Usercolumn {
    private Integer id;
    private String name;
    private Integer isDelete;

    public Usercolumn() {
    }

    public Usercolumn(Integer id, String name, Integer isDelete) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
    }

    public Usercolumn(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Usercolumn( String name) {

        this.name = name;
    }
}
