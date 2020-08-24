package com.maidi.saas.utils.client;

import com.maidi.saas.entity.FileUrlEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *文件服务间调用
 *@Author zhaojing
 *@Date 2020/6/17 14:50
 */
@Component
@FeignClient("rent")
public interface RentClient {

    /**
     *查询文件详情
     *@Name    selecturl
     *@params  [url]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/8/13 15:53
     */
    @PostMapping("/accessory/selecturl")
    String selecturl(@RequestBody(required = false) FileUrlEntity url);
}
