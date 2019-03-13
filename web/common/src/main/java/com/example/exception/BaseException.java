package com.example.exception;

import com.example.response.ResultCode;

/**
 * @author zhangzy
 * @since 12-26
 **/
public class BaseException extends Exception {

    private String code;

    private String msg;

    private BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(ResultCode resultCode) {
        super();
        this.code = resultCode.code();
        this.msg = resultCode.msg();
    }

    public BaseException(ResultCode resultCode, Throwable cause) {
        super(cause);
        this.code = resultCode.code();
        this.msg = resultCode.msg();
    }

    public BaseException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }
}
