package com.example.web;

import com.example.domain.User;
import com.example.persistence.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zb1209144 on 2016/3/25.
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user) {
        logger.warn(user.toString());

        return "redirect:welcome.jsp";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public String users() {

        return userDao.findAllUsers().toString();
    }
}
