package com.maidi.saas.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Classname Device
 * @Description TODO
 * @Date 2020/7/20 10:28
 * @Created by hjchen
 */
@Entity
@Table(name = "sm_device")
public class Device extends BaseEntity {

    @Column(length = 64)
    private String name;
    private int typeId;
    @Column(length = 64)
    private String author;
    @Column(length = 64)
    private String code;
    private Integer status;
    @Column(columnDefinition = "text")
    private String notes;

}
