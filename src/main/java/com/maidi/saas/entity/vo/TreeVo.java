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

    private String id;
    private String name;
    private int level = 1;
    private int projectId;
    private int productId;
    private int taskId;
    private Integer parentId;
    private boolean isParent;
    private List<TaskInfo> taskInfo;
    private List<TreeVo> subTree;
}
