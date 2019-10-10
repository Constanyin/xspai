package com.a.controller;


import com.a.entity.Article;
import com.a.entity.User;
import com.a.entity.WangEditor;
import com.a.service.ArticleService;
import com.a.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @Author liuxin
 * @Date 2019.09.30.0030 14:37
 **/
@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    @Resource
    private ArticleService articleService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/save")
    public String articleSave(Article art) {
        Integer num = articleService.add(art);
        return "ok";
    }

    @RequestMapping(value = "/show",method = RequestMethod.POST)
    public Article articleShow(HttpServletRequest request) {

//        Integer id = (Integer) request.getSession().getAttribute("a_id");
        Integer id = 1;
        Article singleArticle = articleService.findSingleById(id);
        Integer userId = singleArticle.getUserId();
        User user = userService.FindById(userId);
        singleArticle.setUser(user);
        log.info(user.toString());
        return singleArticle;
    }

    @RequestMapping(value = "/like")
    public Article articleLike(HttpServletRequest request) {
        String data = request.getParameter("data");
        log.info(data);
        Article art = null;
//        Integer id = (Integer) request.getSession().getAttribute("a_id");
        Integer id = 17;
        Integer like = articleService.like(Integer.valueOf(data), id);
        if (like > 0) {
            art = articleService.findLike(id);
        }
        return art;
    }


    @RequestMapping(value = "/upload")
    public WangEditor uploadFile(@RequestParam("myFile") MultipartFile multipartFile, HttpServletRequest request) {
        try {
            // 获取项目路径
            String realPath = request.getSession().getServletContext().getRealPath("");
            InputStream inputStream = multipartFile.getInputStream();

            String contextPath = request.getServletContext().getContextPath();

            // 服务器根目录的路径
            String path = realPath.replace(contextPath.substring(1), "");
            // 根目录下新建文件夹upload，存放上传图片
            String uploadPath = path + "upload";
            // 获取文件名称
            String filename = Calendar.getInstance().getTimeInMillis() + "image";
            // 将文件上传的服务器根目录下的upload文件夹
            File file = new File(uploadPath, filename);
            FileUtils.copyInputStreamToFile(inputStream, file);
            // 返回图片访问路径
            String url = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + "/upload/" + filename;
            String[] strs = {url};
            WangEditor we = new WangEditor(strs);
            return we;
        } catch (IOException e) {
            log.error("上传文件失败", e);
        }
        return null;
    }

}
