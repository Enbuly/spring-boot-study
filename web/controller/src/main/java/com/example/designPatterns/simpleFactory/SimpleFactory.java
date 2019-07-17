package com.example.designPatterns.simpleFactory;

/**
 * @author lazy cat
 * @since 2019-07-15
 **/
public class SimpleFactory {
    public Product createProduct(int type) {
        if (type == 1) {
            return new ConcreteProduct1();
        } else if (type == 2) {
            return new ConcreteProduct2();
        }
        return new ConcreteProduct();
    }
}
