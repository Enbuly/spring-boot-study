package com.example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(value = "User", description = "用户信息")
public class User {

    @ApiModelProperty(value = "name")
    private String name;
    @ApiModelProperty(value = "phone")
    private String phone;
}
