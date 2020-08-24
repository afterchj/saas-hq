package com.maidi.saas.entity;

import lombok.Data;

/**
 *任务发起实体
 *@Author zhaojing
 *@Date 2020/8/6 14:29
 */
@Data
public class TaskReplyLaunchEntity {
    /**
     * id
     */
     private Long id;


    /**
     * 发起模块code
     */
    private String startCode;

    /**
     * 接收模块code
     */
    private String receiveCode;

    /**
     * 任务方向（1：发出  2：回复）
     */
    private String taskDirection;

    /**
     * 所属信息主键ID
     */
    private Long infoId;

    /**
     * 发起人id
     */
    private String sponsor;

    /**
     * 接收人id
     */
    private String receiver;

    /**
     * 任务类别（1：询价任务  2：投标任务）
     */
    private String taskType;


    /**
     * 任务来源（1：系统新建）
     */
    private String taskFrom;

    /**
     * 任务开始时间
     */
    private String beginTime;

    /**
     * 任务结束时间
     */
    private String endTime;

    /**
     * 信息简述
     */
    private String describe;

    /**
     * 任务详情
     */
    private String taskInfo;

    /**
     * 附件模块主键ID
     */
    private String enclosure;

    /**
     * 发起时间
     */
    private String created_time;


}
