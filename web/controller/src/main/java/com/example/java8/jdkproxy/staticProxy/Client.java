package com.example.java8.jdkproxy.staticProxy;

/**
 * Client
 *
 * @author lazy cat
 * @since 2020-05-10
 **/
public class Client {

    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userServiceImpl);

        proxy.select();
        proxy.update();
    }
}
