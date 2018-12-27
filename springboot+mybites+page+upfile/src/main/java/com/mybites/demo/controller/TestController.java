package com.mybites.demo.controller;

import com.github.pagehelper.PageHelper;
import com.mybites.demo.bean.User;
import com.mybites.demo.dao.UserDao;
import com.mybites.demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * * Created with IntelliJ IDEA.
 * * User: zhuchenshu
 * * Date: 2018/12/12
 * * Time: 15:56
 * * Description:
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    UserDao userDao;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/dao")
    @ResponseBody
    @Cacheable(cacheNames = "cacheTest")
    public User index() {
        PageHelper.startPage(1,5);
        List<User> list = userMapper.selectAll();
        System.out.println("cache1");
        return userDao.selectByPrimaryKey(1);
    }

    @RequestMapping("/findOne/{id}")
    @ResponseBody
    @Cacheable(cacheNames = "cacheTest")
    public User finOne(@PathVariable("id") Integer id) {
        PageHelper.startPage(1,5);
        User user = userDao.selectByPrimaryKey(id);
        System.out.println("cache2");
        return user;
    }
}
