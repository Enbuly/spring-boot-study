package com.example.exception;

import com.example.constant.ResultCode;

/**
 * @author zhangzhenyan
 * @since  2019-04-11
 **/
public class BaseRuntimeException extends RuntimeException {

    private String code;

    private String msg;

    private BaseRuntimeException(Throwable cause) {
        super(cause);
    }

    public BaseRuntimeException(ResultCode resultCode) {
        super();
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }

    public BaseRuntimeException(ResultCode resultCode, Throwable cause) {
        super(cause);
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
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
