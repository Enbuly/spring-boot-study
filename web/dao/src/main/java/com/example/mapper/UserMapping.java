package com.example.mapper;

import com.example.model.User;

import java.util.List;

/**
 * @author zhangzy
 * @since 11-21
 * **/

public interface UserMapping {
    //user data
    String selectPasswordByUserName(String name);

    List<User> selectAllUser();

    int selectCount();
}
