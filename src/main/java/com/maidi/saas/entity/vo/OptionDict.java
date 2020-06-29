package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @Classname OptionDict
 * @Description TODO
 * @Date 2020/6/4 14:03
 * @Created by hjchen
 */

@Data
public class OptionDict {
    private Integer id;
    private String name;
    private Set<TreeVo> task;
}
