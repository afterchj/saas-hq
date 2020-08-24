package com.maidi.saas.exception;

/**
 *枚举类
 *@Author zhaojing
 *@Date 2020/5/28 11:20
 */
public enum CodeMsg {

    SUCCESS("0000", "操作成功"),
    EMPTY_PARAM_ERROR("9999", "操作失败"),
    INTER_ERROR("9901", "参数非空错误"),
    NOFINISH_ERROR("0003", "该发起模块与接收模块交互任务定义已存在！"),


    /**
     * 控件类型
     */
    LABEL("1","Label"),
    TEXTBOX("2","TextBox"),
    DROPDOWNLIST("3","DropDownList"),
    TEXTAREA("4","TextArea"),
    CHOOSE("5","Choose"),
    TABLE("6","Table");

    // 成员变量
    private String code;
    private String message;
    // 构造方法


    CodeMsg(String code, String message) {
        this.code = code;
        this.message = message;
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
}
