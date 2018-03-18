package com.zxsc.prepare.user.service;

import com.zxsc.prepare.core.util.Constants;
import com.zxsc.prepare.user.dao.UserDao;
import com.zxsc.prepare.user.pojo.UserPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public boolean insertUser(UserPass userPass) {
        return userDao.insertUser(userPass) == Constants.SQL_CHANGE_ONE_LINE;
    }
}
