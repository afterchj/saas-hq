package com.maidi.saas.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Classname Ecode
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */
@Entity
@Table(name = "sm_ecode")
public class Ecode extends BaseEntity {
    private Integer projectId;
    private Integer operatorId;
    private Integer moduleId;
    @Column(length = 64)
    private String ecode;
    @Column(columnDefinition = "text")
    private String notes;
    @Column(columnDefinition = "bit default 0")
    private Boolean status;

//    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @JoinTable(name = "sm_project_stage", joinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "stage_id", referencedColumnName = "id")})
//    private List<ProjectStage> stages;

}
