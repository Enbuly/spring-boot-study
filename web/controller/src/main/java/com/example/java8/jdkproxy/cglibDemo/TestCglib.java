package com.example.java8.jdkproxy.cglibDemo;

/**
 * TestCglib
 *
 * @author lazy cat
 * @since 2020-05-12
 **/
public class TestCglib {

    public static void main(String[] args) {
        UserServiceCglib cglib = new UserServiceCglib();
        UserServiceImpl bookFacedImpl = (UserServiceImpl) cglib.getInstance(new UserServiceImpl());
        bookFacedImpl.addUser();
        bookFacedImpl.editUser();
    }
}
