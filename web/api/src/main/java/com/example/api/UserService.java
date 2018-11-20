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

    String getName(String userName);

    String getPassword(String name);

    PageResponseVo<User> findUserByPage(int currentPage, int pageSize);

}
