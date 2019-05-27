package com.example.filter;

import com.example.wrapper.XssHttpServletRequestWrapper;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * xss过滤器
 *
 * @author zhangzhenyan
 * @since 2019-05-27
 **/
public class XssFilter implements Filter {

    private static boolean IS_INCLUDE_RICH_TEXT = false;//用于接收配置中的参数，决定这个过滤器是否开启

    private List<String> excludes = new ArrayList<>();//用于接收配置中的参数，决定哪些是不需要过滤的url（在这里，也可以修改handleExcludeURL（）方法中相应的代码，使其变更为只需要过滤的url）

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (handleExcludeURL(req)) {
            chain.doFilter(request, response);
            return;
        }
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);
        chain.doFilter(xssRequest, response);
    }

    private boolean handleExcludeURL(HttpServletRequest request) {
        if ((excludes == null || excludes.isEmpty()) && IS_INCLUDE_RICH_TEXT) {
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
    public void init(FilterConfig arg0) {
        String isIncludeRichText = arg0.getInitParameter("isIncludeRichText");
        if (StringUtils.isNotBlank(isIncludeRichText)) {
            IS_INCLUDE_RICH_TEXT = BooleanUtils.toBoolean(isIncludeRichText);
        }

        String temp = arg0.getInitParameter("excludes");
        if (temp != null) {
            String[] url = temp.split(",");
            for (int i = 0; i < url.length; i++) {
                excludes.add(url[i]);
            }
        }
    }

    @Override
    public void destroy() {
    }

}
