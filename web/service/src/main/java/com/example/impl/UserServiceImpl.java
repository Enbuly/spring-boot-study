package com.example.impl;

import com.example.api.UserService;
import com.example.mapper.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author zhangzy
 * @since 11-21
 * @email 120157229@qq.com
 * **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapping userMapping;

    public String getName(String userName){
        return new StringBuilder().append("hello").append(userName).toString();
    }

    public String getPassword(String name){
        return userMapping.selectPasswordByUserName(name);
    }
}
