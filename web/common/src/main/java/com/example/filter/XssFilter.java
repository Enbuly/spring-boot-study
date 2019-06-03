package com.example.filter;

import com.example.wrapper.XssHttpServletRequestWrapper;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * xss过滤器
 *
 * @author lazy cat
 * @since 2019-05-31
 **/
public class XssFilter implements Filter {

    private static final Logger logger = LogManager.getLogger();

    /**
     * 是否过滤富文本内容
     */
    private static boolean IS_INCLUDE_RICH_TEXT = false;

    private List<String> excludes = new ArrayList<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (logger.isDebugEnabled()) {
            logger.debug("xss filter is open");
        }

        HttpServletRequest req = (HttpServletRequest) request;
        if (handleExcludeURL(req)) {
            filterChain.doFilter(request, response);
            return;
        }

        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request, IS_INCLUDE_RICH_TEXT);
        filterChain.doFilter(xssRequest, response);
    }

    private boolean handleExcludeURL(HttpServletRequest request) {

        if (excludes == null || excludes.isEmpty()) {
            return false;
        }

        String url = request.getServletPath();
        for (String pattern : excludes) {
            Pattern p = Pattern.compile("^" + pattern);
            Matcher m = p.matcher(url);
            if (m.find()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) {
        if (logger.isDebugEnabled()) {
            logger.debug("xss filter init ====================");
        }
        String isIncludeRichText = filterConfig.getInitParameter("isIncludeRichText");
        if (StringUtils.isNotBlank(isIncludeRichText)) {
            IS_INCLUDE_RICH_TEXT = BooleanUtils.toBoolean(isIncludeRichText);
        }

        String temp = filterConfig.getInitParameter("excludes");
        if (temp != null) {
            String[] url = temp.split(",");
            excludes = Arrays.asList(url);
        }
    }

    @Override
    public void destroy() {
    }

}
