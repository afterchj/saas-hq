package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Classname TaskRemarkVo
 * @Description TODO
 * @Date 2020/6/9 16:20
 * @Created by hjchen
 */

@Data
public class TaskRemarkVo extends BaseVo {
    private Integer taskId;
    private String notes;
    private String operator;
    private boolean status;
}
