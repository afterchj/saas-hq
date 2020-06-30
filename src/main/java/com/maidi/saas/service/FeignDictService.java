package com.maidi.saas.service;

import com.maidi.saas.config.FeignConfig;
import com.maidi.saas.service.impl.FeignDictHystrix;
import com.maidi.saas.service.impl.FeignUserHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by hjchen on 2020/6/30.
 */

@FeignClient(value = "BASIC2", configuration = FeignConfig.class, fallback = FeignDictHystrix.class)
public interface FeignDictService {

    @RequestMapping(value = "/datadictionary/selproject", method = RequestMethod.GET)
    String listOption();
}

