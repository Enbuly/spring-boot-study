package com.example.java8.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier
 *
 * @author lazy cat
 * @since 2020-04-15
 **/
public class CyclicBarrierExample {

    //用来控制多个线程互相等待，只有当多个线程都到达时，这些线程才会继续执行。
    //和 CountdownLatch 相似，都是通过维护计数器来实现的。
    //线程执行 await() 方法之后计数器会减 1，并进行等待，
    //直到计数器为 0，所有调用 await() 方法而在等待的线程才能继续执行。
    public static void main(String[] args) {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("before..");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.print("after..");
            });
        }
        executorService.shutdown();
    }
}
