package com.a.service.Impl;

import com.a.entity.Article;
import com.a.mapper.IArticleMapper;
import com.a.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liuxin
 * @Date 2019.10.07.0007 14:23
 **/

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private IArticleMapper articleMapper;

    /**
     *  按文章id查找单篇文章
     */
    @Override
    public Article findSingleById(Integer id) {
        Article article = articleMapper.findSingleById(id);
        return article;
    }

    @Override
    public Integer add(Article art) {
        Integer num = articleMapper.add(art);
        return num;
    }

    @Override
    public Integer like(Integer like, Integer id) {
        Integer num = articleMapper.like(like, id);
        return num;
    }

    @Override
    public Article findLike(Integer id) {
        Article article = articleMapper.findLike(id);
        return article;
    }

}
