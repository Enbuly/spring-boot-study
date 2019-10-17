package com.example.api;

import com.example.model.User;
import com.example.responseVo.PageResponseVo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 用户服务
 *
 * @author lazy cat
 * @since 2019-04-11
 **/
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

    /**
     * 测试查询返回map
     *
     * @return Map<Integer, User> 所有用户信息
     **/
    Map<Integer, User> select();

}
