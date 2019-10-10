package com.a.service.Impl;

import com.a.entity.UserArticle;
import com.a.entity.UserData;
import com.a.entity.Usercolumn;
import com.a.mapper.IUserShowMapper;
import com.a.service.IUserShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyh666
 * 2019/10/3 16:40
 */
@Service("userService")
@Slf4j
public class UserShowServiceImpl implements IUserShowService {
    @Resource
    private IUserShowMapper userShowMapper;

    @Override
    public List ShowUserByUID(Integer id) {
        List<UserArticle> byUid = userShowMapper.findByUid(id);
        return byUid;
    }

    @Override
    public List ShowdataByUID(Integer id) {
        List<UserData> userByUid = userShowMapper.findUserByUid(id);
        /*log.info("service"+userByUid);*/
        return  userByUid;
    }
/**/
    @Override
    public List ShowUsercolumn(Integer id) {
        List<Usercolumn> usercolumns = userShowMapper.findcolumnByUid(id);
        return usercolumns;
    }
/*更新用户数据*/
    @Override
    public Integer update(UserData userData) {
        Integer updatenum = userShowMapper.update(userData);
        return updatenum;
    }
    /*用专栏ID查询专栏名*/
    @Override
    public Usercolumn cName(Integer id) {
        Usercolumn usercolumn = userShowMapper.cName(id);
        return usercolumn;
    }

    @Override
    public List findText(UserArticle userarticle) {
        log.info(userarticle.getColumnName());
        List<UserArticle> text = userShowMapper.findText(userarticle);
        log.info("查到的文章"+text);
        return text;
    }


}
