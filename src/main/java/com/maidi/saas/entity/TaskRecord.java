package com.maidi.saas.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Classname TaskRecord
 * @Description TODO
 * @Date 2020/8/16 10:28
 * @Created by hjchen
 */
@Entity
@Table(name = "sm_task_record")
public class TaskRecord extends BaseEntity {
    private Integer taskId;
    @Column(columnDefinition = "text")
    private String content;
    @Column(length = 32)
    private String completeRate;
    @Column(columnDefinition = "bit default 0")
    private boolean isVenture;
    @Column(columnDefinition = "bit default 0")
    private boolean isAdjourn;
    @Column(columnDefinition = "tinyint default 1")
    private Integer ventureType;
    @Column(columnDefinition = "text")
    private String delayCause;

}
