package com.example.designPatterns.test;

import com.example.designPatterns.simpleFactory.Product;
import com.example.designPatterns.simpleFactory.SimpleFactory;

/**
 * @author lazy cat
 * @since 2019-07-15
 **/
public class TestSimpleFactory {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
        Product product1 = simpleFactory.createProduct(2);
        Product product2 = simpleFactory.createProduct(3);
        product.hello();
        product1.hello();
        product2.hello();
    }
}
