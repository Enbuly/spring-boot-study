package com.example.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author zhangzy
 * @email 120157229@qq.com
 * @since 3-7
 **/
@Component
@WebFilter(urlPatterns = "/*", filterName = "authFilter")
public class AuthFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
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
