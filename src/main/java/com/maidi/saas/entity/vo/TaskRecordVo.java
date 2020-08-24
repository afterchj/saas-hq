package com.maidi.saas.entity.vo;


import lombok.Data;

/**
 * @Classname TaskRecord
 * @Description TODO
 * @Date 2020/8/16 10:28
 * @Created by hjchen
 */
@Data
public class TaskRecordVo extends BaseVo {
    private Integer taskId;
    private String content;
    private String completeRate;
    private int isVenture;
    private int isDelay;
    private int ventureType;
    private int status;
    private String delayCause;
    private String delayStartTime;
    private String delayEndTime;

}
