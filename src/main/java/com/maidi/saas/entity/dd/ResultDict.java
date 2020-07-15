package com.maidi.saas.entity.dd;

/**
 * @Classname SearchDict
 * @Description TODO
 * @Date 2020/6/12 10:56
 * @Created by hjchen
 */

public enum ResultDict {

    SUCCESS("000", "成功"), SYSTEM_ERROR("200", "系统错误"),
    ACCOUNT_NOT_CORRECT("101", "登录名错误"), PASSWORD_NOT_CORRECT("102", "登录名密码不正确"),
    ID_NOT_CORRECT("201", "请求的id不是任务id"), NOT_FOUND("202", "没有查询到数据"),
    PARAMS_BLANK("204", "参数不能够为空"), PARAMS_NOT_PARSED("205", "参数解析错误");

    ResultDict(String code, String value) {
        this.value = value;
        this.code = code;
    }

    private String value;
    private String code;

    public String getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

//    public static void main(String[] args) {
//        ResultDict resultDict = SUCCESS;
//        switch (resultDict) {
//            case SUCCESS:
//                System.out.println("成功！");
//                break;
//            case SYSTEM_ERROR:
//                System.out.println(resultDict.getCode() + "\t" + resultDict.getValue());
//                break;
//            default:
//                System.out.println("no result match!");
//                break;
//        }
//    }

}
