package com.shu.ssm.service;

import com.shu.ssm.dao.UserDao;
import com.shu.ssm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * * Created with IntelliJ IDEA.
 * * User: zhuchenshu
 * * Date: 2018/12/9
 * * Time: 16:53
 * * Description:
 */
@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private UserDao userdao;

    public User getUserByID(int id) {
        return this.userdao.selectByPrimaryKey(id);
    }
}
