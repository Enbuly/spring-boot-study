package com.example.studyDemo.singleton;

/**
 * Singleton
 *
 * @author lazy cat
 * @since 2019-07-15
 * 说明：
 * 当Singleton类被加载时，静态内部类SingletonHolder没有被加载进内存。
 * 只有当调用getUniqueInstance()方法从而触发SingletonHolder.INSTANCE时
 * SingletonHolder才会被加载，此时初始化INSTANCE实例，并且JVM能确保INSTANCE只被实例化一次。
 * 这种方式不仅具有延迟初始化的好处，而且由JVM提供了对线程安全的支持。
 **/
public class Singleton {
    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void hello(String name) {
        System.out.println("Singleton: hello " + name);
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}