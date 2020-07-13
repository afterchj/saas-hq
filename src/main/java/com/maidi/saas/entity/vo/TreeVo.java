package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @Classname TreeVo
 * @Description TODO
 * @Date 2020/06/24 11:26
 * @Created by hjchen
 */
@Data
public class TreeVo {

    private int id;
    private String name;
    private int level = 1;
    private int projectId;
    private int parentId;
    private boolean isParent;
    private List<TaskInfo> taskInfo;
}
