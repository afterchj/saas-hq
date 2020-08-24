package com.maidi.saas.entity;

import lombok.Data;

/**
 *任务流转实体
 *@Author zhaojing
 *@Date 2020/8/19 14:30
 */
@Data
public class ProductTaskEntity {

    /**
     * id
     */
    private Long id;

    /**
     * 任务id
     */
    private Long infoId;

    /**
     * 模块code
     */
    private String modularCode;

    /**
     * 信息简述
     */
    private String describe;

    /***
     * 任务详情
     */
    private String taskInfo;

    /**
     * 任务负责人
     */
    private String receiver;

    /**
     * 任务类别（1：询价任务  2：投标任务  3：工艺设计   4：生产环节）
     */
    private String taskType;

    /**
     * 附件模块主键ID
     */
    private String enclosure;

    /**
     * 任务建立人
     */
    private String created_by;

    /**
     * 创建时间
     */
    private String created_time;

    /**
     * 任务来源（1：系统自建）
     */
    private String taskFrom;

}
