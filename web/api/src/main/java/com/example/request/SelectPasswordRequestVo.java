package com.example.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查找密码请求包
 *
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectPasswordRequestVo {

    /**
     * 用户名字
     **/
    private String name;

    /**
     * 用户电话
     **/
    private String phone;
}
