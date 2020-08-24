package com.maidi.saas.utils;

/**
 *通用返参
 *@Author zhaojing
 *@Date 2020/5/22 13:24
 */
public class ApiResponse<T>{
    /**
     * 返回码
     */
    private  String code="0000";

    /**
     * 返回消息
     */
    private  String message="操作成功";

    /**
     * 详细数据
     */
    private  T data;

    public ApiResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponse() {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }




}
