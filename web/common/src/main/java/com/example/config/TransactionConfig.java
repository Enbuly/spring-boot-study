package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;

/**
 * 事务配置
 *
 * @author zhangzhenyan
 * @since  2019-04-11
 **/
@SuppressWarnings("unchecked")
@Configuration
@EnableTransactionManagement
@AutoConfigureAfter({DruidConfig.class})
@MapperScan(basePackages = {"com.example.mapper"})
public class TransactionConfig implements TransactionManagementConfigurer {

    @Resource
    private DruidDataSource druidDataSource;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(druidDataSource);
    }
}
