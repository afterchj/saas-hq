package com.maidi.saas.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Classname GuestTask
 * @Description TODO
 * @Date 2020/8/3 10:28
 * @Created by hjchen
 */
@Entity
@Table(name = "sm_common_task")
public class GuestTask extends BaseEntity {
    private Integer projectId;
    private Integer productId;
    @Column(columnDefinition = "int default 0", nullable = false)
    private Integer parentId;
    private Integer level;
    @Column(length = 64)
    private String name;
    @Column(length = 64)
    private String code;
    @Column(length = 32)
    private String sources;
    @Column(length = 32)
    private String builder;
    @Column(length = 32)
    private String principal;
    @Column(length = 32)
    private String designer;
    @Column(length = 32)
    private String proofreader;
    @Column(length = 32)
    private String output;
    @Column(length = 32)
    private String verifier;
    @Column(length = 32)
    private String version;
    @Column(length = 32)
    private String digest;
    private String imprint;
    @Column(columnDefinition = "text")
    private String description;
    @Column(length = 32)
    private String percentage;
    private Date planStartTime;
    private Date planEndTime;
    private Date actualStartTime;
    private Date actualEndTime;
    @Column(columnDefinition = "tinyint default 1")
    private Integer outputType;
    @Column(columnDefinition = "tinyint default 1")
    private Integer status;
    @Column(columnDefinition = "tinyint default 1")
    private Integer flag;

}
