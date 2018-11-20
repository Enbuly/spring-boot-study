package com.example.controller;

import com.example.api.UserService;
import com.example.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


/**
 * @author zhangzy
 */
@Api(tags = {"UserController-zhangzy"}, description = "用户接口")
@RestController
@SpringBootApplication
@RequestMapping(value = "/springboot")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户打招呼")
    @RequestMapping(value = "/getUserByGet", method = RequestMethod.GET)
    String getUserByGet(@RequestParam(value = "userName") String userName){
        return userService.getName(userName);
        /*return "hello"+userName;*/
    }

    @ApiOperation("getPassword")
    @RequestMapping(value = "/getPassword", method = RequestMethod.GET)
    String getPassword(@RequestParam(value = "userName") String name){
        return userService.getPassword(name);
        /*return "hello"+userName;*/
    }

    @GetMapping(value = "/getUserByGetSecond")
    String getUserByGetSecond(@RequestParam String userName){
        return "Hello " + userName;
    }

    @ApiOperation("拿到用户电话")
    @PostMapping(value = "/getUser")
    public String getUser(@RequestBody User user){
        return "name: "+ user.getName() +"phone: "+user.getPhone();
    }

    @RequestMapping(value = "/getUserByPost", method = RequestMethod.POST)
    String getUserByPost(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }


    @RequestMapping(value = "/getUserByJson",method = RequestMethod.POST)
    String getUserByJson(@RequestBody String data){
        return "Json is " + data;
    }
}
