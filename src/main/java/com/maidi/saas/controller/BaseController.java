package com.maidi.saas.controller;


import com.maidi.saas.entity.dd.ResultDict;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

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

    @ExceptionHandler(NullPointerException.class)
    public Map handleNullException(NullPointerException t) {
        Map result = new HashMap();
        log.error("空指针 :: ", t);
        result.put("code", ResultDict.PARAMS_BLANK.getCode());
        result.put("msg", ResultDict.PARAMS_BLANK.getValue());
        return result;
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    public Map handleFileException(MissingServletRequestPartException t) {
        Map result = new HashMap();
        log.error("文件为空 :: ", t);
        result.put("code", ResultDict.FILE_BLANK.getCode());
        result.put("msg", ResultDict.FILE_BLANK.getValue());
        return result;
    }

}
