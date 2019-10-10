package com.a.mapper;

import com.a.entity.Article;
import org.apache.ibatis.annotations.Param;


public interface IArticleMapper {
    /**
     * 进入文章页并通过传入文章id搜索文章
     * @param id
     * @return
     */
    Article findSingleById(@Param("a_id") Integer id);


    /**
     * 把有数据的对象传入添加到数据库
     * @param art
     * @return 影响行数
     */
    Integer add(@Param("art") Article art);


    Integer like(@Param("like")Integer like,@Param("a_id") Integer id);

    Article findLike(@Param("a_id") Integer id);

}
