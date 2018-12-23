package com.mybites.demo.controller;

import com.github.pagehelper.PageHelper;
import com.mybites.demo.bean.User;
import com.mybites.demo.dao.UserDao;
import com.mybites.demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    public User index() {
        PageHelper.startPage(1,5);
        List<User> list = userMapper.selectAll();
        return userDao.selectByPrimaryKey(1);
    }
}
