package com.example.java8.jdkproxy.staticProxy;

import java.util.Date;

/**
 * UserServiceProxy
 *
 * @author lazy cat
 * @since 2020-05-10
 **/
public class UserServiceProxy implements UserService {

    private UserService target; // 被代理的对象

    UserServiceProxy(UserService target) {
        this.target = target;
    }

    public void select() {
        before();
        target.select();
        after();
    }

    public void update() {
        before();
        target.update();
        after();
    }

    private void before() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    private void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }
}
