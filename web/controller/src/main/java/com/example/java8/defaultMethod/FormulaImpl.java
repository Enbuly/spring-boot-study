package com.example.java8.defaultMethod;

/**
 * Formula的实现类
 *
 * @author lazy cat
 * @since 2020-04-17
 **/
public class FormulaImpl implements Formula {
    public double calculate(int a) {
        return sqrt(a * 100);
    }
}
