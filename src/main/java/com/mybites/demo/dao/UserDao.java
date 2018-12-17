package com.mybites.demo.dao;


import com.mybites.demo.bean.User;
import com.mybites.demo.common.TkMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao{
    User selectByPrimaryKey(Integer id);
}