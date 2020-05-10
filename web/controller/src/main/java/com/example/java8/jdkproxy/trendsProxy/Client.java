package com.example.java8.jdkproxy.trendsProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * demo test
 *
 * @author lazy cat
 * @since 2020-05-10
 **/
public class Client {

    public static void main(String[] args) {

        UserServiceImpl userServiceImpl = new UserServiceImpl();

        //获取对应的 ClassLoader
        ClassLoader classLoader = userServiceImpl.getClass().getClassLoader();

        //获取所有接口的Class，这里的UserServiceImpl只实现了一个接口UserService，
        Class[] interfaces = userServiceImpl.getClass().getInterfaces();

        //创建一个将传给代理类的调用请求处理器，处理所有的代理对象上的方法调用
        //这里创建的是一个自定义的日志处理器，须传入实际的执行对象 userServiceImpl
        InvocationHandler logHandler = new LogHandler(userServiceImpl);

        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, interfaces, logHandler);

        //调用代理的方法
        proxy.select();
        proxy.update();
    }
}