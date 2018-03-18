package com.zxsc.prepare.user.controller;

import com.zxsc.prepare.core.ajax.AjaxResponse;
import com.zxsc.prepare.core.ajax.ResultType;
import com.zxsc.prepare.user.pojo.UserPass;
import com.zxsc.prepare.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;
    private MessageSource messageSource;

    @Autowired
    public UserController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserPass userPass) {
        System.out.println(userPass);
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse register(UserPass userPass, Locale locale) {
        if (userService.countUserByName(userPass) != 0) {
            return new AjaxResponse(ResultType.ERROR,
                    messageSource.getMessage("user-exist", new Object[0], locale));
        }
        if (userService.insertUser(userPass)) {
            System.out.println(userPass.getId());
            return new AjaxResponse(ResultType.OK);
        }
        return new AjaxResponse(ResultType.ERROR,
                messageSource.getMessage("sys-error", new Object[0], locale));
    }
}
