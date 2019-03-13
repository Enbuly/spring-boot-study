package com.example.api;

import com.example.model.User;
import com.example.responseVo.PageResponseVo;
import org.springframework.stereotype.Service;

/**
 * @author zhangzy
 * @since 11-21
 * @email 120157229@qq.com
 * **/
@Service
public interface UserService {

    /**
     * 根据用户名查询用户密码
     *
     * @param name 用户名
     **/
    String getPassword(String name);

    /**
     * 查询用户信息，分页查询
     *
     * @param currentPage 当前页数
     * @param pageSize    页面数量
     **/
    PageResponseVo<User> findUserByPage(int currentPage, int pageSize);

}
