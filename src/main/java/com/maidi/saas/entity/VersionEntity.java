package com.maidi.saas.entity;

import lombok.Data;

/**
 *创建新版本实体
 *@Author zhaojing
 *@Date 2020/8/21 10:31
 */
@Data
public class VersionEntity {

    /**
     * id
     */
    private  Long id;

    /**
     * 创建的任务id
     */
    private  Long taskId;

    /**
     * 类别（1：项目  2：任务分组 3：产品 4：任务）
     */
    private String type;

    /**
     * 新任务名称
     */
    private String newTaskName;

    /**
     * 原任务名称
     */
    private String oldTaskName;

    /**
     * 版本号
     */
    private String version;

    /**
     * 是否包含下级节点（0：否 1：是）
     */
    private String isContain;

    /**
     *  备注
     */
    private String describe;

    /**
     * 创建人
     */
    private String created;

    /**
     * 创建时间
     */
    private String createdTime;
}
