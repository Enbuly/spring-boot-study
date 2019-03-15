package com.example.impl;

import com.example.api.UserService;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.responseVo.PageResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangzy
 * @since 11-21
 * **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public String getPassword(String name){
        return userMapper.selectPasswordByUserName(name);
    }

    public PageResponseVo<User> findUserByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> allItems = userMapper.selectAllUser();
        int countNums = userMapper.selectCount();
        PageResponseVo<User> pageData = new PageResponseVo<>(currentPage, pageSize, countNums);
        pageData.setItems(allItems);
        return pageData;
    }
}
