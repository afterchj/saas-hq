package com.maidi.saas.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Classname Product
 * @Description TODO
 * @Date 2020/8/3 10:28
 * @Created by hjchen
 */
@Entity
@Table(name = "sm_product")
public class Product extends BaseEntity {
    private Integer taskId;
    @Column(columnDefinition = "int default 0", nullable = false)
    private Integer parentId;
    private Integer level;
    private Integer number;
    private Integer availableNum;
    @Column(length = 64)
    private String serialNum;
    @Column(length = 64)
    private String standardNum;
    @Column(columnDefinition = "float(11,1) default '0.00'")
    private float weight;
    @Column(length = 64)
    private String name;
    @Column(length = 64)
    private String code;
    @Column(length = 32)
    private String texture;
    @Column(length = 32)
    private String specification;
    private String version;
    private String imprint;
    private Date planStartTime;
    private Date planEndTime;
     private Date actualStartTime;
    private Date actualEndTime;
    @Column(columnDefinition = "tinyint default 2")
    private Integer flag;
    @Column(columnDefinition = "tinyint default 1")
    private Integer facadeId;
    @Column(columnDefinition = "tinyint default 1")
    private Integer supplyId;
    @Column(columnDefinition = "tinyint default 1")
    private Integer outsourceId;
    @Column(columnDefinition = "tinyint default 1")
    private Integer outSupplyId;
    @Column(columnDefinition = "text")
    private String description;

}
