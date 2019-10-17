package com.example.controller;

import com.example.api.UserService;
import com.example.requestVo.PageRequestVo;
import com.example.responseVo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * user controller
 *
 * @author lazy cat
 * @since 2019-04-11
 **/
@Api(description = "user controller")
@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @ApiOperation("分页查询并做一些其他任务")
    @PostMapping(value = "/getUserInformationAndDoSomething")
    public ResultVo getUserInformationAndDoSomething(@RequestHeader(value = "token") String token,
                                                     @RequestBody PageRequestVo pageRequestVo) {
        checkToken(token);
        checkPageRequestVo(pageRequestVo);
        return ResultVo.success(userService.findUserByPage(pageRequestVo.getCurrentPage(),
                pageRequestVo.getPageSize()), "分页查询成功!");
    }

    @ApiOperation("getPasswordByName")
    @RequestMapping(value = "/getPasswordByName", method = RequestMethod.GET)
    public ResultVo getPassword(@RequestHeader(value = "token") String token,
                                @RequestParam(value = "user_name") String name) {
        checkToken(token);
        checkName(name);
        return ResultVo.success(userService.getPassword(name), "获取密码成功");
    }

    @ApiOperation("testPathVariable")
    @GetMapping(path = "hello/{name}")
    public ResultVo testPathVariable(@RequestHeader(value = "token") String token, @PathVariable String name) {
        checkName(name);
        checkToken(token);
        log.info("hello " + name);
        return ResultVo.success("访问成功啦" + name + "!");
    }

    /**
     * 访问地址：http://localhost:8080/springboot/testMap?user_name=zzy
     **/
    @ApiOperation("testMap")
    @GetMapping(value = "/testMap")
    public ResultVo testMap(@RequestHeader(value = "token") String token, @RequestParam Map<String, String> map) {
        checkToken(token);
        String userName = map.get("user_name");
        log.info("user_name: " + userName);
        return ResultVo.success("user_name: " + userName, "testMap success");
    }

    @ApiOperation("testSelectMap")
    @GetMapping(value = "/testSelectMap")
    public ResultVo testSelectMap() {
        return ResultVo.success(userService.select(), "testSelectMap success");
    }
}
