package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author zhangzhenyan
 * @since  2019-04-11
 **/
@Configuration
@EnableAsync
public class ThreadPoolTaskExecutorConfig {

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolTaskExecutorConfig.class);

    @Value("${async.executor.coreSize}")
    private int corePoolSize;

    @Value("${async.executor.maxSize}")
    private int maxPoolSize;

    @Value("${async.executor.queueCapacity}")
    private int queueCapacity;

    @Value("${async.executor.prefix}")
    private String namePrefix;

    @Bean(name = "asyncServiceExecutor")
    public Executor asyncServiceExecutor() {

        logger.info("start asyncServiceExecutor");

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(namePrefix);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //执行初始化
        executor.initialize();
        return executor;
    }
}
