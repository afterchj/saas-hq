package com.maidi.saas.entity;

import lombok.Data;

/**
 *任务实体
 *@Author zhaojing
 *@Date 2020/8/21 11:22
 */
@Data
public class TaskEntity {

    /**
     * id
     */
    private Long id;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 版本号
     */
    private String version;

}
