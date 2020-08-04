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

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public Map testPush(@RequestBody(required = false) String params) {
        log.warn("params {}", params);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        redisTemplate.convertAndSend("test_topic",params);
        return result;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "current profiles is " + profile + ",server port is " + port;
    }


    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        long size = file.getSize() / 1024;
        log.warn("fileName {} size {}", fileName, size);

        String filePath = "D:/mnt/";
        try {
//            File dest = new File(filePath, fileName);
            File dest = File.createTempFile(filePath, fileName);
            file.transferTo(dest);
            OSSFileUtil.upload(fileName, dest);
            log.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return "上传失败！";
    }
}
