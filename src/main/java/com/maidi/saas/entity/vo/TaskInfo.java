package com.maidi.saas.entity.vo;

import lombok.Data;

/**
 * @Classname TaskInfo
 * @Description TODO
 * @Date 2020/07/10 10:40
 * @Created by hjchen
 */
@Data
public class TaskInfo {
    private String name;
    private String principal="";
    private String percentage="";
    private String planCycle="";
}
