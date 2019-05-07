package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Configuration
@EnableScheduling
public class StaticScheduleTask {

    private Logger log = LoggerFactory.getLogger(StaticScheduleTask.class);

    /**
     * 每隔5秒执行一次：0/5 * * * * ?
     * 每隔5分执行一次：0 0/5 * * * ?
     * 每天半夜12点执行一次：0 0 0 * * ?
     * 每天中午十二点执行一次：0 0 12 * * ?
     * 每天18点、22点执行一次：0 0 18,22 * * ?
     **/
    @Scheduled(cron = "0 0/5 * * * ?")
    private void configureTasks() {
        log.info("执行静态定时任务时间: " + LocalDateTime.now());
    }

}
