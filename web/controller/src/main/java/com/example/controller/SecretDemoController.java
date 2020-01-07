package com.example.controller;

import com.example.annotation.secret.SecretBody;
import com.example.model.City;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * secret example
 *
 * @author lazy cat
 * @since 2020-01-07
 **/
@Api(description = "secret example")
@RestController
@RequestMapping(value = "/secret")
public class SecretDemoController {

    /**
     * 测试http报文解密
     **/
    @SecretBody
    @PostMapping("secretBody")
    public void secretBody(@RequestBody City city) {
        System.out.println(city.toString());
    }
}
