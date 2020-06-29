package com.maidi.saas.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Classname Project
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */
@Entity
@Table(name = "sm_project")
public class Project extends BaseEntity {
    private Integer sequence;
    private Integer bdId;
    private Integer managerId;
    private Integer typeId;
    private Integer stageId;
    private Integer customerId;
    private String name;
    private Date planStartTime;
    private Date planEndTime;
    private Date actualStartTime;
    private Date actualEndTime;
    @Column(length = 64)
    private String code;
    @Column(columnDefinition = "text")
    private String extFields;
    @Column(columnDefinition = "text")
    private String description;


//    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @JoinTable(name = "sm_project_stage", joinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "stage_id", referencedColumnName = "id")})
//    private List<ProjectStage> stages;

}
