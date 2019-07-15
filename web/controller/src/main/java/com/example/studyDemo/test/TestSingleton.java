package com.example.studyDemo.test;

import com.example.studyDemo.singleton.Singleton;
import com.example.studyDemo.singleton.Singleton2;

/**
 * TestSingleton
 *
 * @author lazy cat
 * @since 2019-07-15
 **/
public class TestSingleton {

    public static void main(String[] args) {
        TestSingleton test = new TestSingleton();
        test.testSingleton();
        test.testSingleton2();
    }

    private void testSingleton() {
        Singleton singleton = Singleton.getUniqueInstance();
        singleton.hello("zzy");
    }

    private void testSingleton2() {
        Singleton2 singleton2 = Singleton2.getUniqueInstance();
        singleton2.hello("zzy");
    }
}
