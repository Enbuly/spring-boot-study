package com.example.controller;

import com.example.api.UserService;
import com.example.constant.ResultCode;
import com.example.exception.ParamsCheckException;
import com.example.responseVo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Login Controller
 *
 * @author lazy cat
 * @since 2019-04-25
 **/
@RestController
@RequestMapping(value = "/userManagement")
public class LoginController extends BaseController {

    @Resource
    private UserService userService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private Logger log = LoggerFactory.getLogger(LoginController.class);

    //测试xss地址:http://localhost:8080/sys/login?user_name=zzy&password=11<srcipt>alert(zzy)</srcipt>
    @GetMapping(value = "/login")
    public ResultVo<String> login(@RequestParam(value = "user_name") String name,
                                  @RequestParam(value = "password") String password) {

        log.info("name: " + name + ", password: " + password + "!");

        checkName(name);
        checkPassword(password);

        String token;
        if (password.equals(userService.getPassword(name))) {
            token = new Date().getTime() + name;
            stringRedisTemplate.opsForValue().set(token, name, 60 * 2, TimeUnit.SECONDS);
            log.info("redis set :" + token);
        } else {
            throw new ParamsCheckException(ResultCode.USER_PASSWORD_ERROR);
        }

        return ResultVo.success(token, "login success!");
    }

    @GetMapping(value = "/checkLoginOrNot")
    public ResultVo<String> checkLoginOrNot(@RequestHeader(value = "token") String token) {

        checkToken(token);

        String name = stringRedisTemplate.opsForValue().get(token);

        if (!StringUtils.isEmpty(name)) {
            return ResultVo.success("true", "该用户已经登陆!");
        } else {
            return ResultVo.success("false", "该用户未登陆!");
        }

    }

}
