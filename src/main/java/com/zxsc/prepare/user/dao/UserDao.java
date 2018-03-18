package com.zxsc.prepare.user.dao;

import com.zxsc.prepare.core.annotation.MyBatisRepository;
import com.zxsc.prepare.user.pojo.User;
import com.zxsc.prepare.user.pojo.UserPass;

@MyBatisRepository
public interface UserDao {
    int insertUser(UserPass userPass);

    int countUserByName(UserPass userPass);
}
