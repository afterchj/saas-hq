package com.maidi.saas.entity.vo;


import lombok.Data;

/**
 * @Classname TemplateVo
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */
@Data
public class TemplateVo {

    private Integer projectId;
    private Integer templateId;
    private Integer typeId;
    private String templateName;
    private String notes;

}
