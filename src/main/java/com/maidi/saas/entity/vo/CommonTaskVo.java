package com.maidi.saas.entity.vo;


import lombok.Data;


/**
 * @Classname GuestTask
 * @Description TODO
 * @Date 2020/8/3 10:28
 * @Created by hjchen
 */
@Data
public class CommonTaskVo extends BaseVo {
    private Integer projectId;
    private Integer parentId;
    private Integer level;
    private String name;
    private String code;
    private String designer;
    private String designerId;
    private String proofreader;
    private String proofreaderId;
    private String verifier;
    private String verifierId;
    private String version;
    private String digest;
    private String imprint;
    private String description;
    private String percentage;
    private String planStartTime;
    private String planEndTime;
    private String actualStartTime;
    private String actualEndTime;
    private String planCycle = "";
    private String actualCycle = "";
    private String output;
    private Integer outputType;
    private int status;
    private Integer flag;
    private Integer type = 1;

}
