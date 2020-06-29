package com.maidi.saas.entity.vo;

import lombok.Data;
/**
 * @Classname TaskVo
 * @Description TODO
 * @Date 2020/6/9 15:22
 * @Created by hjchen
 */

@Data
public class TaskCommentVo extends BaseVo {
    private Integer taskId;
    private String operator;
    private String notes;
    private String completeRate;

}
