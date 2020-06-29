package com.maidi.saas.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * @Classname Task
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */
@Entity
@Table(name = "sm_task")
public class Task extends BaseEntity {
    private Integer projectId;
    private Integer parentId;
    private Integer level;
    private String name;
    @Column(length = 32)
    private String stage;
    @Column(length = 32)
    private String principal;
    @Column(length = 32)
    private String timeSheet;
    @Column(length = 32)
    private String workload;
    @Column(length = 32)
    private String priority;
    @Column(columnDefinition = "text")
    private String description;
    @Column(length = 32)
    private String percentage;
    private Date planStartTime;
    private Date planEndTime;


//    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @JoinTable(name = "sm_project_stage", joinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "stage_id", referencedColumnName = "id")})
//    private List<ProjectStage> stages;

}
