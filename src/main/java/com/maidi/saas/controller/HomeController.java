package com.maidi.saas.controller;

import com.maidi.saas.entity.dd.ResultDict;
import com.maidi.saas.utils.OSSFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname HomeController
 * @Description TODO
 * @Date 2020/6/15 15:59
 * @Created by hjchen
 */

@RestController
@Slf4j
public class HomeController {

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${server.port}")
    private Integer port;

    @Value("${downPath}")
    private String downPath;
    @Value("${uploadPath}")
    private String uploadPath;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public Map testPush(@RequestBody(required = false) String params) {
        log.warn("params {}", params);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        redisTemplate.convertAndSend("test_topic", params);
        return result;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "current profiles is " + profile + ",server port is " + port;
    }

    @PostMapping("/upload")
    public Map upload(@RequestParam("file") MultipartFile file) {
        Map result = new HashMap();
        if (file.isEmpty()) {
            result.put("code", ResultDict.PARAMS_BLANK.getCode());
            result.put("msg", ResultDict.PARAMS_BLANK.getValue());
        }
        String fileName = file.getOriginalFilename();
        double size = file.getSize() / 1024.0;
        log.warn("fileName {} size {}", fileName, size);
        try {
            File dest = new File(uploadPath, fileName);
//            File dest = File.createTempFile(uploadPath, fileName);
            file.transferTo(dest);
            String path = OSSFileUtil.upload(fileName, dest);
            log.warn("destPath {} targetPath", dest.getParent(), path);
            result.put("code", ResultDict.SUCCESS.getCode());
            result.put("msg", ResultDict.SUCCESS.getValue());
            return result;
        } catch (IOException e) {
            log.error("errorMessage {}", e);
            result.put("code", ResultDict.PARAMS_NOT_PARSED.getCode());
            result.put("msg", ResultDict.PARAMS_NOT_PARSED.getValue());
        }
        return result;
    }
}
