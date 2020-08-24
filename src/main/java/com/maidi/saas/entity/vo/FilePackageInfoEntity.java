package com.maidi.saas.entity.vo;

import lombok.Data;

/**
 *文件详情实体
 *@Author zhaojing
 *@Date 2020/8/19 16:09
 */
@Data
public class FilePackageInfoEntity {

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
     * 任务名称
     */
    private String taskName;

    /**
     * 包含产品数
     */
    private Integer productNum;

    /**
     * 包含任务数
     */
    private Integer taskNum;

    /**
     * 包含文件数
     */
    private Integer fileNum;

    /**
     * 打包说明
     */
    private String describe;

    /**
     * 文件包条形码
     */
    private String barcode;

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
