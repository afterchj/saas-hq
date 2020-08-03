package com.maidi.saas.controller;

import com.maidi.saas.service.RedisService;
import com.maidi.saas.utils.OSSFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private RedisService redisService;

    @RequestMapping(value = "/push", method = RequestMethod.GET)
    public String testPush() {
        Map map = new HashMap();
        map.put("id", 1);
        map.put("name", "测试1");
        redisService.pushMsg1("demo_topic", map);
        return "success";
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
