package com.chen.springbootlearn.exception;

import com.chen.springbootlearn.common.ErrorCode;

public class CustomAuthException extends BaseException {
    public CustomAuthException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public CustomAuthException(ErrorCode errorCode, Object data) {
        this.errorCode = errorCode;
        this.data = data;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Object getData() {
        return data;
    }
}
