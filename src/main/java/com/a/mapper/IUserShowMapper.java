package com.a.mapper;

import com.a.entity.UserArticle;
import com.a.entity.UserData;
import com.a.entity.Usercolumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface IUserShowMapper {
List<UserArticle>findByUid(@Param("id") Integer id);
List<UserData> findUserByUid(@Param("id1") Integer id);
List<Usercolumn> findcolumnByUid(@Param("id2") Integer id);
Integer update(@Param("User") UserData userData);
Usercolumn cName(@Param("id3") Integer id);
List<UserArticle> findText(@Param("User1") UserArticle userarticle);
}
