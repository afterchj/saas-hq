package com.maidi.saas;

import com.alibaba.fastjson.JSONObject;
import com.maidi.saas.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyApplicationTests {

    @Autowired
    private RedisService redisService;

    @Test
    public void testPush() {
        JSONObject map=new JSONObject();
        map.put("id", 1);
        map.put("name", "测试1");
        redisService.pushMsg("test_topic", map);
    }
}
