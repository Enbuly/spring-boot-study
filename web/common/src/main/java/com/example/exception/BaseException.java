package com.example.exception;

import com.example.constant.ResultCode;

/**
 * 通用异常
 *
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
public class BaseException extends Exception {

    private String code;

    private String msg;

    public BaseException(ResultCode resultCode) {
        super();
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
