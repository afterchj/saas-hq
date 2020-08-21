package com.maidi.saas.entity.vo;



import lombok.Data;

import java.util.Date;

/**
 * @Classname Product
 * @Description TODO
 * @Date 2020/8/3 10:28
 * @Created by hjchen
 */
@Data
public class ProductVo extends BaseVo {
    private Integer taskId;
    private Integer parentId;
    private Integer level;
    private Integer number;
    private Integer availableNum;
    private String serialNum;
    private String standardNum;
    private float weight;
    private String productName;
    private String code;
    private String texture;
    private String specification;
    private String version;
    private String imprint;
    private String planStartTime;
    private String planEndTime;
    private String actualStartTime;
    private String actualEndTime;
    private Integer flag;
    private Integer facadeId;
    private Integer supplyId;
    private Integer outsourceId;
    private Integer outSupplyId;
    private String description;
    private String planCycle="";
    private String actualCycle="";

}
