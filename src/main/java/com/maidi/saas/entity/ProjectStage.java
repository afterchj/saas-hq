package com.maidi.saas.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @Classname Firm
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */

@Entity
@Table(name = "sm_stage")
public class ProjectStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

//    @ManyToMany(mappedBy = "stages")
//    private List<Project> projects;
}
