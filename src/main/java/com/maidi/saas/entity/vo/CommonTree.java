package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @Classname CommonTree
 * @Description TODO
 * @Date 2020/06/24 11:26
 * @Created by hjchen
 */
@Data
public class CommonTree {

    private int id;
    private String name;
    private int level = 1;
    private Integer parentId;
    private boolean isParent;
    private List<CommonTree> subTree;
}
