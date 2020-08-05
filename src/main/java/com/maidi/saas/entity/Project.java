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
    @Column(columnDefinition = "tinyint default 0")
    private Integer level;
    @Column(columnDefinition = "tinyint default 1")
    private Integer type;
    private Integer sequence;
    private String bdId;
    private String managerId;
    private String typeId;
    private String stageId;
    private String customerId;
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
