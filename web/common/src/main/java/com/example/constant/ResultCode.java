package com.example.constant;

/**
 * 返回码
 *
 * @author zhangzhenyan
 * @since 2019-04-11
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

    /**
     * 请求参数错误
     **/
    PARAMETER_ERROR("100001", "请求参数错误");

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
