package com.a.entity;

import lombok.Data;

/**
 * @Author liuxin
 * @Date 2019.10.09.0009 11:12
 **/
@Data
public class WangEditor {


    private Integer errno; //错误代码，0 表示没有错误。
    private String[] data; //已上传的图片路径


    public WangEditor(String[] data) {
        super();
        this.errno = 0;
        this.data = data;

    }
}