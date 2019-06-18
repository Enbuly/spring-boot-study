package com.example.wrapper;

import com.example.util.JsoupUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * XssHttpServletRequestWrapper
 *
 * @author lazy cat
 * @since 2019-05-31
 **/
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private boolean isIncludeRichText;

    private HttpServletRequest httpServletRequest;

    public XssHttpServletRequestWrapper(HttpServletRequest request, boolean isIncludeRichText) {
        super(request);
        this.isIncludeRichText = isIncludeRichText;
        httpServletRequest = request;
    }

    /**
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤
     * 如果需要获得原始的值，则通过super.getHeaders(name)来获取
     * getHeaderNames 也可能需要覆盖
     */
    @Override
    public String getHeader(String name) {
        return cleanIllegalChars(name);
    }

    /**
     * 覆盖getParameter方法，将参数名和参数值都做xss过滤。
     * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取
     * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
     */
    @Override
    public String getParameter(String name) {
        return cleanIllegalChars(name);
    }

    @Override
    public String[] getParameterValues(String name) {
        if (!isIncludeRichText) {
            return super.getParameterValues(name);
        }

        name = JsoupUtil.clean(name);
        String[] arr = super.getParameterValues(name);
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = JsoupUtil.clean(arr[i]);
            }
        }
        return arr;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream()));
        String line = br.readLine();
        StringBuilder result = new StringBuilder();
        while (line != null) {
            result.append(JsoupUtil.clean(line));
            line = br.readLine();
        }

        return new WrappedServletInputStream(new ByteArrayInputStream(result.toString().getBytes()));
    }

    private String cleanIllegalChars(String name) {
        if (!isIncludeRichText) {
            return super.getParameter(name);
        }
        name = JsoupUtil.clean(name);
        String value = super.getParameter(name);
        if (StringUtils.isNotBlank(value)) {
            value = JsoupUtil.clean(value);
        }
        return value;
    }

    private class WrappedServletInputStream extends ServletInputStream {

        private InputStream stream;

        WrappedServletInputStream(InputStream stream) {
            this.stream = stream;
        }

        @Override
        public int read() throws IOException {
            return stream.read();
        }

        @Override
        public boolean isFinished() {
            return true;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener) {
        }
    }

}
