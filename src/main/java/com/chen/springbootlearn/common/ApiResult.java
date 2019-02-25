package com.chen.springbootlearn.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class ApiResult extends LinkedHashMap<String, Object> {

    private final LocaleMessage localeMessage;

    @Autowired
    public ApiResult(LocaleMessage localeMessage) {
        this.localeMessage = localeMessage;
    }

    public ApiResult success() {
        ErrorCode errorCode = ErrorCode.SUCCESS;
        this.put("code", errorCode.getCode());
        this.put("msg", localeMessage.getMessage(errorCode.getMsgKey()));
        this.put("data", null);
        return this;
    }

    public ApiResult success(Object data) {
        ErrorCode errorCode = ErrorCode.SUCCESS;
        this.put("code", errorCode.getCode());
        this.put("msg", localeMessage.getMessage(errorCode.getMsgKey()));
        this.put("data", data);
        return this;
    }

    public ApiResult result(ErrorCode errorCode) {
        this.put("code", errorCode.getCode());
        this.put("msg", localeMessage.getMessage(errorCode.getMsgKey()));
        this.put("data", null);
        return this;
    }

    public ApiResult result(ErrorCode errorCode, Object data) {
        this.put("code", errorCode.getCode());
        this.put("msg", localeMessage.getMessage(errorCode.getMsgKey()));
        this.put("data", data);
        return this;
    }
}
