package com.maidi.saas.entity.vo;

import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Classname ProjectVo
 * @Description TODO
 * @Date 2020/6/4 10:49
 * @Created by hjchen
 */

@Data
public class ProjectVo extends BaseVo {

    private Integer sequence;
    private String projectName;
    private String projectCode;
    private Date planStartTime;
    private Date planEndTime;
    private Date actualStartTime;
    private Date actualEndTime;
    private String projectDesc;
    private String extFields;
    private Integer projectBDId;
    private Integer projectStageId;
    private Integer projectManagerId;
    private Integer projectTypeId;
    private Integer customerId;

}
