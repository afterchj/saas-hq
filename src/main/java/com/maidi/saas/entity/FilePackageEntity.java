package com.maidi.saas.entity;

import lombok.Data;

/**
 *w文件打包实体
 *@Author zhaojing
 *@Date 2020/8/18 17:07
 */
@Data
public class FilePackageEntity {

    /**
     * id
     */
    private Long id;

    /**
     * 打包的对应任务id
     */
    private Long taskId;

    /**
     * 文件包名称
     */
    private String packageName;

    /**
     * 打包说明
     */
    private String describe;

    /**
     * 文件包条形码
     */
    private String barcode;

    /**
     * 打包的文件code
     */
    private String files;

    /**
     * 包含文件数
     */
    private Integer fileNum;

    /**
     * 文件包版本
     */
    private String version;

    /**
     * 打包人
     */
    private String created;

    /**
     * 打包时间
     */
    private String createdTime;

}
