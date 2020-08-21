package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @Classname TreeVo
 * @Description TODO
 * @Date 2020/06/24 11:26
 * @Created by hjchen
 */
@Data
public class TreeVo {

    private String id;
    private String name;
    private int level;
    private int type;
    private int projectId;
    private int taskId;
    private Integer parentId;
    private boolean isParent;
    private List<TaskInfo> taskInfo;
    private List<TreeVo> subTree;
}
