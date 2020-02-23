package com.example.java8.defaultMethod;

/**
 * 接口的默认方法
 *
 * @author lazy cat
 * @since 2020-02-23
 **/
public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
