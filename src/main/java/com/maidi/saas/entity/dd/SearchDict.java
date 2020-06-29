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
    int projectId;
    int parentId;
    int pageNum = 1;
    int pageSize = 30;
    private String name;
    private String code;
    private String principal;
    private String projectName;
    private String moduleName;
    private String updateTime;
    private String stage;

}
