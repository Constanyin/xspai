package com.a.controller;


import com.a.entity.UserArticle;
import com.a.entity.UserData;
import com.a.entity.Usercolumn;
import com.a.service.IUserShowService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author lyh666
 * 2019/9/30 15:43
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
@Resource
    private IUserShowService userShowService;
/*查文章的*/
@RequestMapping(value = "/show",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String ShowText(){

    List list = userShowService.ShowUserByUID(1);
    String json = JSON.toJSONString(list);
    /*log.info("文章的集合"+list);
    log.info("文章的json"+json);*/
    return json;
}
/*查用户信息的*/
@RequestMapping(value = "/showUser",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String ShowUser(){
        List<UserData> list = userShowService.ShowdataByUID(1);
        String json = JSON.toJSONString(list);
        /*log.info("用户信息list"+list);
        log.info("用户信息JSON"+json);*/
        if (list.size()==0){
            return "1";
        }else {
            return json;
        }
    }
    /*查询用户专栏*/
    @RequestMapping(value = "/showcolumn",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String ShowColumn(HttpServletRequest request){
        //用户ID
        Integer id = (Integer) request.getSession().getAttribute("id");
        List list = userShowService.ShowUsercolumn(1);
        log.info("专栏"+list);
        String string = JSON.toJSONString(list);
        return string;
    }
    /*给文章展示界面传文章ID*/
    @RequestMapping(value = "/textid",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String textId(HttpServletRequest request){
        String id = request.getParameter("id");
        /*log.info(id);*/
        request.getSession().setAttribute("a_id",id);
        return "1";
    }
    /*更新用户数据*/
    @RequestMapping(value = "update",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String update(HttpServletRequest request){
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        /*log.info("修改"+username+email+phone);*/
        //用户ID
        /*Integer id = (Integer) request.getSession().getAttribute("id");*/
        UserData userData=new UserData(1,username,email,phone);
        Integer update = userShowService.update(userData);
        log.info("是否修改成功"+update);
        if (update>0){
            return "1";
        }else {
            return "0";
        }

    }
    //上传单张图片
    @RequestMapping(value = "/register2",method = RequestMethod.POST)
    public void upload(MultipartFile upload,HttpServletRequest request) throws IOException {
        System.out.println("1"+upload.getOriginalFilename());
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        log.info("图片"+filename);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        //完成文件的上传
        upload.transferTo(new File(path,filename));
        //添加进数据库
        log.info(filename);


    }
    //根据专栏查询用户文章
    @RequestMapping(value = "findcolumn",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String findcolumn(HttpServletRequest request){
        /*专栏ID*/
        String cid = request.getParameter("id");
        int i = Integer.parseInt(cid);
        /*用专栏名字查专栏名字*/
        /*在文章表中用专栏名查数据*/
        /*用户ID*/
        Integer id = (Integer) request.getSession().getAttribute("id");
        log.info("id"+i);
        Usercolumn usercolumn = userShowService.cName(i);
        String name = usercolumn.getName();
        log.info("查到的专栏"+name);
        /*根据专栏名查询文章*/
        UserArticle userarticle =new UserArticle(name);
        log.info("专栏名"+ userarticle.getColumnName());
        List list = userShowService.findText(userarticle);
        log.info("查到的文章"+list);
        String string = JSON.toJSONString(list);
        return string;
    }





}
