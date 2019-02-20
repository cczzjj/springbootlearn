package com.chen.springbootlearn.common;

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

    public ApiResult(ErrorCode errorCode, Object data) {
        this.code = errorCode.getCode();
        this.data = data;
    }

    public ApiResult(ErrorCode errorCode, String msg, Object data) {
        this.code = errorCode.getCode();
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
