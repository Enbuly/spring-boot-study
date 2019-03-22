package com.example.exception;

import com.example.response.ResultCode;

/**
 * @author zhangzy
 * @since 12-26
 **/
public class BaseRuntimeException extends RuntimeException {

    private String code;

    private String msg;

    private BaseRuntimeException(Throwable cause) {
        super(cause);
    }

    public BaseRuntimeException(ResultCode resultCode) {
        super();
        this.code = resultCode.code();
        this.msg = resultCode.msg();
    }

    public BaseRuntimeException(ResultCode resultCode, Throwable cause) {
        super(cause);
        this.code = resultCode.code();
        this.msg = resultCode.msg();
    }

    public BaseRuntimeException(String code, String msg) {
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