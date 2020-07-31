package com.maidi.saas.service;

import com.maidi.saas.config.FeignConfig;
import com.maidi.saas.service.impl.ZuulUserHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Created by hongjian.chen on 2018/12/4.
 */

@FeignClient(value = "service-zuul", configuration = FeignConfig.class, fallback = ZuulUserHystrix.class)
public interface ZuulUserService {

//    @GetMapping(value = "/uic/userList")
//    Map getAll();

//    @RequestMapping(value = "/uic/userList", method = RequestMethod.GET)
//    String getAll();

    @RequestMapping(value = "/organization/user", method = RequestMethod.GET)
    String getAllUser();

    @RequestMapping(value = "/basic/datadictionary/selproject", method = RequestMethod.GET)
    String listProjectOption();
}

