package com.maidi.saas.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Classname Template
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */
@Entity
@Table(name = "sm_template")
public class Template extends BaseEntity {
    private Integer projectId;
    private Integer templateId;
    private Integer typeId;
    @Column(length = 64)
    private String name;
    @Column(columnDefinition = "text")
    private String notes;

}
