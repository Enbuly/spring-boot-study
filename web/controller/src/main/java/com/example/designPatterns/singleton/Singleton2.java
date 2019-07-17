package com.example.designPatterns.singleton;

/**
 * Singleton2
 *
 * @author lazy cat
 * @since 2019-07-15
 * double check lock
 **/
public class Singleton2 {

    private volatile static Singleton2 uniqueInstance;

    private Singleton2() {
    }

    public static Singleton2 getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton2();
                }
            }
        }
        return uniqueInstance;
    }

    public void hello(String name) {
        System.out.println("Singleton2: hello " + name);
    }

}