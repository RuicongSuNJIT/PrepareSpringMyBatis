package com.zxsc.prepare.user.controller;

import com.zxsc.prepare.core.ajax.AjaxResponse;
import com.zxsc.prepare.core.ajax.ResultType;
import com.zxsc.prepare.user.pojo.UserPass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
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
    public AjaxResponse register(UserPass userPass) {

        return new AjaxResponse(ResultType.OK);
    }
}
