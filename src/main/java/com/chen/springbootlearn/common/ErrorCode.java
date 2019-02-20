package com.chen.springbootlearn.common;

public enum ErrorCode {

    SUCCESS(0, "success"),

    /**
     * token验证相关
     */
    TOKEN_REQUIRED(10001, "token.required"),
    TOKEN_INVALID(10002, "token.invalid"),
    TOKEN_ERROR(10003, "token.error"),

    /**
     * 用户相关
     */
    USER_UNEXIST(11001, "user.unexist"),

    /**
     * 未知错误
     */
    UNKNOW_ERROR(99999, "unknown.error");

    private int code;
    private String msgKey;

    ErrorCode(int code, String msgKey) {
        this.code = code;
        this.msgKey = msgKey;
    }

    public int getCode() {
        return code;
    }

    public String getMsgKey() {
        return msgKey;
    }
}
