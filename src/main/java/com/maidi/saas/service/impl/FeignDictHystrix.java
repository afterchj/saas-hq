package com.maidi.saas.service.impl;

import com.alibaba.fastjson.JSON;
import com.maidi.saas.entity.dd.ResultDict;
import com.maidi.saas.service.FeignDictService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongjian.chen on 2018/12/4.
 */

@Component
public class FeignDictHystrix implements FeignDictService {

    @Override
    public String listOption() {
        Map result = new HashMap();
        result.put("code", ResultDict.SYSTEM_ERROR.getCode());
        result.put("msg", ResultDict.SYSTEM_ERROR.getValue());
        return JSON.toJSONString(result);
    }
}
