package com.example.api;

import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/**
 * 异步服务
 *
 * @author lazy cat
 * @since 2019-04-11
 **/
@Service
public interface ThreadServer {

    /**
     * 异步任务1
     *
     * @throws Exception 执行错误抛出异常
     **/
    void doTaskOne(CountDownLatch countDownLatch) throws Exception;

    /**
     * 异步任务2
     *
     * @throws Exception 执行错误抛出异常
     **/
    void doTaskTwo(CountDownLatch countDownLatch) throws Exception;

    /**
     * 异步任务3
     *
     * @throws Exception 执行错误抛出异常
     **/
    void doTaskThree(CountDownLatch countDownLatch) throws Exception;

    /**
     * 异步任务4
     *
     * @return Future 返回线程执行结果
     * @throws Exception 执行错误抛出异常
     **/
    Future<String> doTaskFourth() throws Exception;
}
