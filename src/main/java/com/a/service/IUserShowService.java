package com.a.service;


import com.a.entity.User;
import com.a.entity.UserData;
import com.a.entity.Usercolumn;

import java.util.List;

/**
 * @author lyh666
 * 2019/10/3 16:40
 */
public interface IUserShowService {
//根据用户ID查询
List ShowUserByUID(Integer id);
//根据用户ID查询用户信息
List ShowdataByUID(Integer id);
//根据用户ID查询用户专栏
List ShowUsercolumn(Integer id);
//修改用户表信息
Integer update(UserData userData);
//根据专栏ID查询专栏名
Usercolumn cName(Integer id);
/*根据专栏名查询文章*/
List findText(User user);
}
