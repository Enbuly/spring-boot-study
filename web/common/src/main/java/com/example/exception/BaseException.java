package com.example.exception;

import com.example.constant.ResultCode;

/**
 * 通用异常
 *
 * @author zhangzhenyan
 * @since  2019-04-11
 **/
public class BaseException extends Exception {

    private String code;

    private String msg;

    private BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(ResultCode resultCode) {
        super();
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }

    public BaseException(ResultCode resultCode, Throwable cause) {
        super(cause);
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
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
