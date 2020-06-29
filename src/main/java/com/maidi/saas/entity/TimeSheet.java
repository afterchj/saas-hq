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
@Table(name = "sm_timesheet")
public class TimeSheet extends BaseEntity {
    @Column(length = 64)
    private String name;
    @Column(length = 32)
    private String laborHour;

}
