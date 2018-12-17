package com.shu.ssm.controller;

import com.shu.ssm.model.User;
import com.shu.ssm.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * * Created with IntelliJ IDEA.
 * * User: zhuchenshu
 * * Date: 2018/12/9
 * * Time: 16:53
 * * Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        logger.info("测试日志");
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserByID(userId);
        //绑定对象到User.jsp
        model.addAttribute("user", user);
        return "User";
    }
}
