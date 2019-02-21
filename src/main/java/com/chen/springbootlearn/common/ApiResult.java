package com.chen.springbootlearn.common;

import lombok.Getter;

@Getter
public class ApiResult {
    /**
     * 错误码，对应{@link ErrorCode}，表示一种错误类型
     * 如果是成功，则code为200
     */
    private int code;
    /**
     * 对错误的具体解释
     */
    private String msg;
    /**
     * 返回的结果包装在value中，value可以是单个对象
     */
    private Object data;

    public ApiResult(ErrorCode errorCode) {
        this.code = errorCode.getCode();
    }

    public ApiResult(ErrorCode errorCode, String msg) {
        this.code = errorCode.getCode();
        this.msg = msg;
    }

    public ApiResult(ErrorCode errorCode, Object data) {
        this.code = errorCode.getCode();
        this.data = data;
    }

    public ApiResult(ErrorCode errorCode, String msg, Object data) {
        this.code = errorCode.getCode();
        this.msg = msg;
        this.data = data;
    }

    public ApiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
