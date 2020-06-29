package com.maidi.saas.service;

import com.maidi.saas.config.FeignConfig;
import com.maidi.saas.service.impl.FeignUserHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by hongjian.chen on 2018/12/4.
 */

@FeignClient(value = "organization2", configuration = FeignConfig.class, fallback = FeignUserHystrix.class)
public interface FeignUserService {

//    @GetMapping(value = "/userList")
//    Map getAll();

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String getAllUser();
}

