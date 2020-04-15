package com.example.java8.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountdownLatch
 *
 * @author lazy cat
 * @since 2020-04-15
 **/
public class CountdownLatchExample {

    //用来控制一个或者多个线程等待多个线程。
    //维护了一个计数器 cnt，每次调用 countDown() 方法会让计数
    //器的值减 1，减到 0 的时候，那些因为调用 await() 方法而在等待的线程就会被唤醒。
    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            try {
                countDownLatch.await();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print("end1...");
        });

        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("run..");
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        System.out.println("end2...");
        executorService.shutdown();
    }
}
