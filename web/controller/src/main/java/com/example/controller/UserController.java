package com.example.controller;

import com.example.api.UserService;
import com.example.requestVo.PageRequestVo;
import com.example.response.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

/**
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
@Api(tags = {"UserController-zhangzy"}, description = "用户接口")
@RestController
@SpringBootApplication
@RequestMapping(value = "/springboot")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @ApiOperation("分页查询测试")
    @GetMapping(value = "/getUserPage")
    ResultVo getUserPage(PageRequestVo pageRequestVo) {
        return ResultVo.success(userService.findUserByPage(pageRequestVo.getCurrentPage(),
                pageRequestVo.getPageSize()), "分页查询成功!");
    }

    @ApiOperation("getPasswordByName")
    @RequestMapping(value = "/getPasswordByName", method = RequestMethod.GET)
    ResultVo getPassword(@RequestHeader(value = "token") String token,
                         @RequestParam(value = "userName") String name) {
        log.info("token :" + token);
        return ResultVo.success(userService.getPassword(name), "获取密码成功");
    }

    @ApiOperation("testPathVariable")
    @GetMapping(path = "hello/{name}")
    ResultVo testPathVariable(@PathVariable String name) {
        log.info("hello " + name);
        return ResultVo.success("hello :" + name, "访问成功啦!");
    }

    /**
     * 校验电话号码
     **/
    private void checkPhone(String phone) throws Exception {
        if (!Pattern.compile("^1[3|4|5|7|8|9][0-9]\\d{4,8}$").matcher(phone).matches()) {
            throw new Exception();
        }
    }
}
