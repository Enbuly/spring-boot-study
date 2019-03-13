package com.example.api;

/**
 * @author zhangzy
 * @since 3-13
 **/
public interface ThreadServer {

    /**
     * 异步任务1
     *
     * @throws Exception 执行错误抛出异常
     **/
    void doTaskOne() throws Exception;

    /**
     * 异步任务2
     *
     * @throws Exception 执行错误抛出异常
     **/
    void doTaskTwo() throws Exception;

    /**
     * 异步任务3
     *
     * @throws Exception 执行错误抛出异常
     **/
    void doTaskThree() throws Exception;
}
