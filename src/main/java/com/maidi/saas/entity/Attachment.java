package com.maidi.saas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Classname Attachment
 * @Description TODO
 * @Date 2020/6/28 10:28
 * @Created by hjchen
 */
@Entity
@Table(name = "sm_attachment")
public class Attachment extends BaseEntity {
    private Integer fileId;
    private Integer hostId;
    @Column(length = 64)
    private String path;
    @Column(length = 64)
    private String version;
    @Column(length = 128)
    private String url;
    @Column(length = 64)
    private String fileName;
    @Column(columnDefinition = "double(11,1) default '0.00'")
    private Double size;
    @Column(columnDefinition = "tinyint default '0'")
    private int type;
    @Column(columnDefinition = "tinyint default '1'")
    private int versionType;
    @Column(columnDefinition = "bit default 0")
    private boolean isCheck;
    @Column(columnDefinition = "bit default 0")
    private boolean isVerify;
    @Column(length = 32)
    private String format;
    @Column(length = 32)
    private String owner;
    @Column(columnDefinition = "text")
    private String notes;
}
