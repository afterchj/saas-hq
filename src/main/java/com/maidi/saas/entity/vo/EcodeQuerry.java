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
public class EcodeQuerry {

    private Integer id;
    private String ecode;
    private String notes;
    private Integer projectId;
    private Integer moduleId;
    private String projectName;
    private String moduleName;
    private String operator;
    private Boolean status;
    private Integer sequence;
    private List<OptionDict> projects;
    private List<OptionDict> modules;
    private Date createTime;
    private Date updateTime;
}
