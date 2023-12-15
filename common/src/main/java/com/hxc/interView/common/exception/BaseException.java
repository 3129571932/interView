package com.hxc.interView.common.exception;

public class BaseException extends RuntimeException{

    private String message;
    private Integer errorCode;

    private Object data;

    public BaseException() {
        super();
    }

    public BaseException(String message, Integer errorCode, Object data) {
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
