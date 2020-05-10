package com.example.java8.jdkproxy.staticProxy;

/**
 * UserServiceImpl
 *
 * @author lazy cat
 * @since 2020-05-10
 **/
class UserServiceImpl implements UserService {

    @Override
    public void select() {
        System.out.println("select ...");
    }

    @Override
    public void update() {
        System.out.println("update ...");
    }
}