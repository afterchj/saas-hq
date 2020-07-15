package com.maidi.saas.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

/**
 * @Classname BaseVo
 * @Description TODO
 * @Date 2020/6/12 17:23
 * @Created by hjchen
 */

@Data
@JsonIgnoreProperties(value = {"handler"})
public class BaseVo {
    private int id;
    private Date createTime;
    private Date updateTime;
}
