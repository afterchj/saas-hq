package com.maidi.saas.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @Classname CustomerVo
 * @Description TODO
 * @Date 2020/6/4 14:13
 * @Created by hjchen
 */

@Data
public class CustomerVo {

    private Integer id;
    private String name;
    private String info;
    private String customerGrade;
    private String customerType;
}
