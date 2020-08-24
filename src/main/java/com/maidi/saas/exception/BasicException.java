package com.maidi.saas.exception;

/**
 *异常类
 *@Author zhaojing
 *@Date 2020/5/28 11:10
 */
public class BasicException extends Exception {
    private static final long serialVersionUID = 1L;
    private String code;

    private String message;

    public BasicException(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public BasicException() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BasicException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
