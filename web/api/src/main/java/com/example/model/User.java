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
    private int id;
    private String name;
    private double salary;
    private int status;
    private String phone;
    private String password;
}
