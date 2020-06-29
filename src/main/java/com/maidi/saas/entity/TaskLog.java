package com.maidi.saas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Classname TaskLog
 * @Description TODO
 * @Date 2020/6/22 15:41
 * @Created by hjchen
 */
@Entity
@Table(name = "sm_task_log")
public class TaskLog  extends BaseEntity{

    private Integer taskId;
    @Column(length = 32)
    private String operator;
    @Column(columnDefinition = "text")
    private String notes;
    private Boolean status;
}
