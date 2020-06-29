package com.maidi.saas.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Classname BaseEntity
 * @Description TODO
 * @Date 2020/6/12 17:15
 * @Created by hjchen
 */

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "datetime default now()")
    private Date createTime;
    @Column(columnDefinition = "datetime default now()")
    private Date updateTime;
}
