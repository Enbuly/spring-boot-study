package com.example.studyDemo.simpleFactory;

/**
 * @author lazy cat
 * @since 2019-07-15
 **/
public class ConcreteProduct implements Product {

    @Override
    public void hello() {
        System.out.println("ConcreteProduct...");
    }
}
