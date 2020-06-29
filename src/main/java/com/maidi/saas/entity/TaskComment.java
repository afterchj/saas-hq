package com.maidi.saas.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Classname Task
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */
@Entity
@Table(name = "sm_task_comment")
public class TaskComment extends BaseEntity {
    private Integer taskId;
    @Column(length = 32)
    private String operator;
    @Column(columnDefinition = "text")
    private String notes;
    private String completeRate;


//    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @JoinTable(name = "sm_project_stage", joinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "stage_id", referencedColumnName = "id")})
//    private List<ProjectStage> stages;

}
