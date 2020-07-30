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
    @Column(columnDefinition = "int default 0", nullable = false)
    private Integer parentId;
    @Column(length = 64)
    private String name;
    @Column(length = 32)
    private String laborHour;
    @Column(columnDefinition = "tinyint default 1")
    private Integer flag;
    @Column(columnDefinition = "tinyint default 1", nullable = false)
    private Integer level;

}
