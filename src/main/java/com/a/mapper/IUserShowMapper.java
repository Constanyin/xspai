package com.a.mapper;

import com.a.entity.User;
import com.a.entity.UserData;
import com.a.entity.Usercolumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface IUserShowMapper {
List<User>findByUid(@Param("id") Integer id);
List<UserData> findUserByUid(@Param("id1") Integer id);
List<Usercolumn> findcolumnByUid(@Param("id2") Integer id);
Integer update(@Param("User") UserData userData);
Usercolumn cName(@Param("id3") Integer id);
List<User> findText(@Param("User1")User user);
}
