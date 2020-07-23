package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Classname TaskVo
 * @Description TODO
 * @Date 2020/6/9 15:22
 * @Created by hjchen
 */

@Data
public class TaskVo extends BaseVo {

    private Integer level = 1;
    private Integer flag = 1;
    private Integer sequence;
    private Integer projectId;
    private Integer parentId;
    private Boolean isParent;
    private String taskName;
    private String stage;
    private String timeSheet;
    private String workload;
    private String principal;
    private String priority;
    private String description;
    private String percentage;
    private String planCycle;
    private Date planStartTime;
    private Date planEndTime;

}
