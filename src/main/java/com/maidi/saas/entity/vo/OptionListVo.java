package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @Classname OptionListVo
 * @Description TODO
 * @Date 2020/6/5 9:30
 * @Created by hjchen
 */

@Data
public class OptionListVo {

    private List<OptionDict> customer;
    private List<OptionDict> projectManager;
    private List<OptionDict> projectBD;
    private List<OptionDict> projectStage;
    private List<OptionDict> projectType;

}
