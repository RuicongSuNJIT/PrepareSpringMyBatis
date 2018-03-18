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
@RequestMapping(value = "/user")
public class UserController {

}
