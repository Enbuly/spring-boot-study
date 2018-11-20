package com.example.api;

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
}
