package com.a.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author lyh666
 * 2019/10/4 14:56
 */
@Component
@Data
public class UserArticle {
    private Integer id;
    private String  name;
    private String article;
    private String createDate;
    private Integer loves;
    private String columnName;

    public UserArticle() {
    }

    public UserArticle(Integer id, String name, String article, String createDate, Integer loves, String columnName) {
        this.id = id;
        this.name = name;
        this.article = article;
        this.createDate = createDate;
        this.loves = loves;
        this.columnName = columnName;
    }

    public UserArticle(String columnName) {
        this.columnName = columnName;
    }
}
