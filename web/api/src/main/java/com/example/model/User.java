package com.example.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User", description = "用户信息")
public class User implements Serializable {

    /**
     * 用户id
     **/
    private int id;

    /**
     * 用户名字
     **/
    private String name;

    /**
     * 用户工资
     **/
    private double salary;

    /**
     * 用户状态
     * **/
    private int status;

    /**
     * 用户电话
     * **/
    private String phone;

    /**
     * 用户密码
     * **/
    private String password;
}
