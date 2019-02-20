package com.chen.springbootlearn.exception;

import com.chen.springbootlearn.common.ErrorCode;

public abstract class BaseException extends RuntimeException {
    protected ErrorCode errorCode;
    protected Object data;
}
