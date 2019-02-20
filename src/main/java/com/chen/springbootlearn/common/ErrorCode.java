package com.chen.springbootlearn.common;

public enum ErrorCode {

    SUCCESS(0, "success"),

    /**
     * token验证相关
     */
    TOKEN_REQUIRED(10001, ""),
    TOKEN_INVALID(10002, "token失效"),
    TOKEN_ERROR(10003, "token错误"),

    /**
     * 用户相关
     */
    USER_UNEXIST(11001, "用户不存在"),

    /**
     * 未知错误
     */
    UNKNOW_ERROR(99999, "未知错误");

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
