package com.example.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhangzhenyan
 * @since  2019-04-11
 **/
@Component
public class AuthFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        if (token != null) {
            stringRedisTemplate.opsForValue().set("token :", token);
        }
        log.info(request.getHeader("token"));
        try {
            log.info("come to filter! method doFilter-");
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (ServletException | IOException e) {
            log.info(e.getMessage());
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("come to filter! method init-");
    }

    @Override
    public void destroy() {
        log.info("come to filter! method destroy-");
    }
}
