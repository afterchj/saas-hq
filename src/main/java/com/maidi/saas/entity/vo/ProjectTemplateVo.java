package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Classname ProjectTemplateVo
 * @Description TODO
 * @Date 2020/6/10 14:29
 * @Created by hjchen
 */

@Data
public class ProjectTemplateVo {

    private Integer id;
    private Integer projectId;
    private String templateName;
    private String templateType;
    private String notes;
    private Date createTime;
    private Date updateTime;
}
