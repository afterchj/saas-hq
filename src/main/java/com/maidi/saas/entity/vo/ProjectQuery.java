package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @Classname ProjectQuery
 * @Description TODO
 * @Date 2020/6/5 14:53
 * @Created by hjchen
 */

@Data
public class ProjectQuery extends BaseVo {
    private Integer sequence;
    private String projectName;
    private String projectCode;
    private String projectStage;
    private Integer projectStageId;
    private String projectManager;
    private String projectBD;
    private String customer;
    private String projectType;
    private String projectProgress;
    private Date planStartTime;
    private Date planEndTime;
    private Date actualStartTime;
    private Date actualEndTime;
}
