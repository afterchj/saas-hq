package com.maidi.saas.entity.dd;

/**
 * Created by hjchen on 2020/6/19.
 */

public enum Week {

    MON("mon","周一"),TUS("tus","周二"),WED("web","周三"),
    THR("thr","周四"),FRR("frr","周五"),SAT("sat","周六"),SUN("sun","周日");

    private String weenEn;
    private String weekCN;

    Week(String weenEn, String weekCN) {
        this.weenEn = weenEn;
        this.weekCN = weekCN;
    }

    public String getWeenEn() {
        return weenEn;
    }

    public String getWeekCN() {
        return weekCN;
    }
}
