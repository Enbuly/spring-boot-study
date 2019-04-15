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
 * 用户服务实现
 *
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public String getPassword(String name) {
        return userMapper.selectPasswordByUserName(name);
    }

    public PageResponseVo<User> findUserByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> allItems = userMapper.selectAllUser();
        PageResponseVo<User> pageData = new
                PageResponseVo<>(currentPage, pageSize, allItems.size());
        pageData.setItems(allItems);
        return pageData;
    }
}
