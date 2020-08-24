package com.maidi.saas.entity.vo;


import lombok.Data;

/**
 * @Classname Attachment
 * @Description TODO
 * @Date 2020/6/28 10:28
 * @Created by hjchen
 */

@Data
public class AttachmentVo extends BaseVo {
    private Integer oldId;
    private Integer fileId;
    private Integer hostId;
    private String version;
    private String url;
    private String code;
    private String fileName;
    private Double size;
    private int fileType;
    private int versionType;
    private int isCheck;
    private int isVerify;
    private int isCommit;
    private String owner;
    private String notes;
}
