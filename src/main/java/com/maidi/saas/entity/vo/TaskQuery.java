package com.maidi.saas.entity.vo;

import com.maidi.saas.entity.TaskComment;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Classname TaskQuery
 * @Description TODO
 * @Date 2020/6/10 13:18
 * @Created by hjchen
 */

@Data
public class TaskQuery extends BaseVo {

    private String principal;
    private String percentage;
    private List<TaskComment> content;

}
