package com.maidi.saas.entity.dd;

import lombok.Data;

/**
 * @Classname SearchDict
 * @Description TODO
 * @Date 2020/6/12 10:56
 * @Created by hjchen
 */

@Data
public class SearchDict {
    private int projectId;
    private int parentId;
    private int stageId;
    private int taskId;
    private String name;
    private String projectCode;
    private String principal;
    private String projectName;
    private String moduleName;
    private String updateTime;
    private String stage;
    private int pageNum = 1;
    private int pageSize = 30;

}
