package com.example.wrapper;

import com.alibaba.druid.util.StringUtils;
import com.example.util.JsoUpUtil;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * XssHttpServletRequestWrapper
 *
 * @author zhangzhenyan
 * @since 2019-05-27
 **/
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private HttpServletRequest orgRequest;

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        orgRequest = request;
    }

    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
        if (req instanceof XssHttpServletRequestWrapper) {
            return ((XssHttpServletRequestWrapper) req).getOrgRequest();
        }
        return req;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {//get

        BufferedReader br = new BufferedReader(new InputStreamReader(orgRequest.getInputStream()));
        String line = br.readLine();
        String result = "";
        if (line != null) {
            result += clean(line);
        }

        return new WrappedServletInputStream(new ByteArrayInputStream(result.getBytes()));
    }

    @Override
    public String getParameter(String name) {
        if (("content".equals(name) || name.endsWith("WithHtml"))) {
            return super.getParameter(name);
        }
        name = clean(name);
        String value = super.getParameter(name);
        if (!StringUtils.isEmpty(value)) {
            value = clean(value);
        }
        return value;
    }

    @Override
    public Map getParameterMap() {
        Map map = super.getParameterMap();
        // 返回值Map
        Map<String, String> returnMap = new HashMap<String, String>();
        Iterator entries = map.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, clean(value).trim());
        }
        return returnMap;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] arr = super.getParameterValues(name);
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = clean(arr[i]);
            }
        }
        return arr;
    }

    private HttpServletRequest getOrgRequest() {
        return orgRequest;
    }

    private String clean(String content) {
        String result = JsoUpUtil.clean(content);
        return result;
    }

    private class WrappedServletInputStream extends ServletInputStream {
        private InputStream stream;

        WrappedServletInputStream(InputStream stream) {
            this.stream = stream;
        }

        public void setStream(InputStream stream) {
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
