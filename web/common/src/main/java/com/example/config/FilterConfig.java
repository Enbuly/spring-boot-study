package com.example.config;

import com.example.filter.AuthFilter;
import com.example.filter.XssFilter;
import com.google.common.collect.Maps;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Map;

/**
 * filter 配置
 *
 * @author lazy cat
 * @since  2019-04-11
 **/
@SuppressWarnings("unchecked")
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean securityFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(AuthFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("AuthFilter");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(XssFilter());
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = Maps.newHashMap();
        initParameters.put("excludes", "/img/*,/js/*,/css/*");
        initParameters.put("isIncludeRichText", "true");
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }

    @Bean
    public Filter AuthFilter() {
        return new AuthFilter();
    }

    @Bean
    public Filter XssFilter() {
        return new XssFilter();
    }

}
