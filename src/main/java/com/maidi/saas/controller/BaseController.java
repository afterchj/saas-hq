package com.maidi.saas.controller;


import com.maidi.saas.entity.dd.ResultDict;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BaseController {

    @ExceptionHandler(Throwable.class)
    public Map handleException(Throwable t) {
        Map result = new HashMap();
        log.error("严重 :: ", t);
        result.put("code", ResultDict.SYSTEM_ERROR.getCode());
        result.put("msg", ResultDict.SYSTEM_ERROR.getValue());
        return result;
    }

}
