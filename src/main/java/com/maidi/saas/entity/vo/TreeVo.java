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

    private Integer id;
    private Integer level = 1;
    private Integer projectId;
    private Integer parentId;
    private String name;
    private Set<TreeVo> subTask;
}
