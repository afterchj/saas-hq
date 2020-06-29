package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Classname EcodeVo
 * @Description TODO
 * @Date 2020/6/4 16:58
 * @Created by hjchen
 */

@Data
public class EcodeVo extends BaseVo {

    private String ecode;
    private String notes;
    private Integer projectId;
    private Integer moduleId;
    private Integer operatorId;
    private String projectName;
    private String moduleName;
    private String operator;
    private Boolean status;
}
