package com.zxsc.prepare.user.controller;

import com.zxsc.prepare.core.ajax.AjaxResponse;
import com.zxsc.prepare.core.ajax.ResultType;
import com.zxsc.prepare.core.util.Constants;
import com.zxsc.prepare.core.util.ErrorUtil;
import com.zxsc.prepare.core.util.Key;
import com.zxsc.prepare.core.util.Message;
import com.zxsc.prepare.user.pojo.User;
import com.zxsc.prepare.user.pojo.UserPass;
import com.zxsc.prepare.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping(value = "/authority")
public class AuthorityController {
    private UserService userService;
    private MessageSource messageSource;

    @Autowired
    public AuthorityController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model, HttpSession session) {
        model.addAttribute(Key.ERROR, ErrorUtil.pickFromSession(session));
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserPass userPass, HttpSession session, Locale locale) {
        User user = userService.selectUserByNamePass(userPass);
        System.out.println(user);
        if (user != null) {
            session.setAttribute(Key.USER, user);
            return "redirect:/";
        } else {
            session.setAttribute(Key.ERROR, new Error(
                    messageSource.getMessage(Message.NO_USER_PASS, Constants.EMPTY_PARAM, locale)));
            return "redirect:/authority/login";
        }
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
                    messageSource.getMessage(Message.USER_EXIST, Constants.EMPTY_PARAM, locale));
        }
        if (userService.insertUser(userPass)) {
            System.out.println(userPass.getId());
            return new AjaxResponse(ResultType.OK);
        }
        return new AjaxResponse(ResultType.ERROR,
                messageSource.getMessage(Message.SYS_ERROR, Constants.EMPTY_PARAM, locale));
    }
}
