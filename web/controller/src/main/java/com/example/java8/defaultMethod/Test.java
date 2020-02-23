package com.example.java8.defaultMethod;

/**
 * 接口的默认方法
 *
 * @author lazy cat
 * @since 2020-02-23
 **/
public class Test {

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
    }
}
