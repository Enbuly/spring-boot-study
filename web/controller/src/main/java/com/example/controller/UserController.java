package com.example.controller;

import com.example.api.UserService;
import com.example.model.User;
import com.example.requestVo.PageRequestVo;
import com.example.responseVo.PageResponseVo;
import com.github.pagehelper.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

/**
 * @author zhangzy
 * @email 120157229@qq.com
 * @since 11-21
 **/
@Api(tags = {"UserController-zhangzy"}, description = "用户接口")
@RestController
@SpringBootApplication
@RequestMapping(value = "/springboot")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("分页查询")
    @GetMapping(value = "/getUserPage")
    PageResponseVo<User> getUserPage(PageRequestVo pageRequestVo) {
        return userService.findUserByPage(pageRequestVo.getCurrentPage(),
                pageRequestVo.getPageSize());
    }

    @ApiOperation("getPasswordByName")
    @RequestMapping(value = "/getPasswordByName", method = RequestMethod.GET)
    String getPassword(@RequestParam(value = "userName") String name) {
        return userService.getPassword(name);
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
