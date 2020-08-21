package com.maidi.saas.entity.vo;


import lombok.Data;


/**
 * @Classname GuestTask
 * @Description TODO
 * @Date 2020/8/3 10:28
 * @Created by hjchen
 */
@Data
public class TaskGroupVo extends BaseVo {
    private Integer projectId;
    private Integer parentId;
    private Integer level;
    private String name;
    private String code;
    private String sources;
    private String builder;
    private String builderId;
    private String principal;
    private String principalId;
    private String version;
    private String digest;
    private String imprint;
    private String description;
    private String actualStartTime;
    private String actualEndTime;
    private String actualCycle = "";
    private Integer flag;
    private Integer type = 2;

}
