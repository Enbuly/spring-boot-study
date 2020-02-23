package com.example.java8.Lambda;

/**
 * CarImpl
 *
 * @author lazy cat
 * @since 2020-02-23
 **/
public class CarImpl implements Car {

    public static void main(String[] args) {

        // 1.传统方式 需要new接口的实现类来完成对接口的调用
        Car car1 = new CarImpl();
        car1.drive();

        Car car4 = () -> System.out.println("Drive Ferrari");
        car4.drive();
    }

    @Override
    public void drive() {
        System.out.println("Drive Benz");
    }
}
