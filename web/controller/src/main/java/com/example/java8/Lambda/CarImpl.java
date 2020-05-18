package com.example.java8.Lambda;

import java.util.HashSet;

/**
 * CarImpl
 *
 * @author lazy cat
 * @since 2020-02-23
 **/
public class CarImpl implements Car {

    public static void main(String[] args) {

        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add("1");
        stringHashSet.add("2");
        System.out.println(stringHashSet.toString());

        Car car1 = new CarImpl();
        car1.drive();

        Car car4 = () -> System.out.println("Drive Ferrari");
        car4.drive();

        CarPro carPro = (String a, String b) -> a + b;
        System.out.println(carPro.run("zzy", " is good"));

        CarPro carPro1 = (String a, String b) -> {
            System.out.println("lambda--");
            return a + "do something" + b;
        };
        String result = carPro1.run("zzy ", " is good");
        System.out.println(result);
    }

    @Override
    public void drive() {
        System.out.println("Drive Benz");
    }
}
