package com.example.cas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

/**
 * cas example
 *
 * @author zhangzhenyan
 * @since 2019-05-29
 **/
class SimpleLock {

    private Logger log = LoggerFactory.getLogger(SimpleLock.class);

    /**
     * Java中的原子操作(CAS)持有自旋锁的线程对象
     **/
    private AtomicReference<Thread> owner = new AtomicReference<>();

    /**
     * lock函数将owner设置为当前线程，并且预测原来的值为空
     * 当有第二个线程调用lock操作时由于owner的值不为空，导致循环
     * 一直被执行，直至第一个线程调用unlock函数将owner设置为null，第二个线程才能进入临界区
     **/
    void lock() {
        Thread curThread = Thread.currentThread();
        while (!owner.compareAndSet(null, curThread)) {
            log.info("try to get lock...");
        }
    }

    /**
     * unlock将owner的值设置为null，并且预测值为当前线程
     **/
    void unlock() {
        Thread cur = Thread.currentThread();
        if (owner.compareAndSet(cur, null)) {
            log.info("unlock...");
        }
    }
}
