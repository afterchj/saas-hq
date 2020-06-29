package com.maidi.saas.service.impl;

import com.alibaba.fastjson.JSON;
import com.maidi.saas.entity.dd.ResultDict;
import com.maidi.saas.service.FeignUserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hongjian.chen on 2018/12/4.
 */

@Component
public class FeignUserHystrix implements FeignUserService {

    @Override
    public String getAllUser() {
        Map result = new HashMap();
        result.put("code", ResultDict.SYSTEM_ERROR.getCode());
        result.put("msg", ResultDict.SYSTEM_ERROR.getValue());
        return JSON.toJSONString(result);
    }
}
