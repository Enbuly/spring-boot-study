package com.example.impl;

import com.example.api.UserService;
import com.example.mapper.UserMapping;
import com.example.model.User;
import com.example.responseVo.PageResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangzy
 * @since 11-21
 * @email 120157229@qq.com
 * **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapping userMapping;

    public String getPassword(String name){
        return userMapping.selectPasswordByUserName(name);
    }

    public PageResponseVo<User> findUserByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> allItems = userMapping.selectAllUser();
        int countNums = userMapping.selectCount();
        PageResponseVo<User> pageData = new PageResponseVo<>(currentPage, pageSize, countNums);
        pageData.setItems(allItems);
        return pageData;
    }
}
