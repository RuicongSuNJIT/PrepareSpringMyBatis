package com.zxsc.prepare.user.controller;

import com.zxsc.prepare.user.pojo.UserPass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserPass userPass) {
        System.out.println(userPass);
        return "index";
    }
}
