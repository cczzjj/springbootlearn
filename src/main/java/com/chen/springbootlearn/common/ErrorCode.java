package com.chen.springbootlearn.common;

public enum ErrorCode {

    WELCOME(0, "welcome"),
    SUCCESS(0, "success"),
    LOGIN_SUCCESS(0, "login.success"),
    BAN_SUCCESS(0, "ban.success"),

    ACCESS_FAIL(401, "access.fail"),

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
    USER_AUTH_ERROR(11002, "user.auth.error"),
    USER_PASSWORD_ERROR(11003, "user.password.error"),

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
