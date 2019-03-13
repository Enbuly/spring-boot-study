package com.example.response;

/**
 * @author zhangzy
 * @since 3-7
 **/
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS("1", "success"),

    /**
     * 失败
     */
    ERROR("0", "error"),

    LIVER_FUNCTION_ERROR2("0", "天冬氨酸氨基转移酶不在正常范围");

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应消息
     */
    private String msg;

    ResultCode(String code) {
        this.code = code;
    }

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }

}
