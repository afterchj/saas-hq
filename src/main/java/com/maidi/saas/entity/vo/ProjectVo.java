package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.Date;


/**
 * @Classname ProjectVo
 * @Description TODO
 * @String 2020/6/4 10:49
 * @Created by hjchen
 */

@Data
public class ProjectVo extends BaseVo {

    private Integer sequence;
    private String projectName;
    private String projectCode;
    private String planStartTime;
    private String planEndTime;
    private String actualStartTime;
    private String actualEndTime;
    private String projectDesc;
    private String extFields;
    private String projectBDId;
    private String projectStageId;
    private String projectManagerId;
    private String projectTypeId;
    private String customerId;

}
