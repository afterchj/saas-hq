package com.maidi.saas.entity.vo;

import lombok.Data;

/**
 * @Classname TimeSheetVo
 * @Description TODO
 * @Date 2020/6/10 13:41
 * @Created by hjchen
 */

@Data
public class TimeSheetVo {
    private Integer id;
    private String laborName;
    private String laborHour;
    private int parentId = 1;
    private int level = 1;
    private int flag = 1;
}
