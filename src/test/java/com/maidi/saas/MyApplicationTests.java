package com.maidi.saas;

import com.alibaba.fastjson.JSON;
import com.maidi.saas.entity.vo.OptionDict;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void testPush() {
        OptionDict dict=new OptionDict();
        dict.setId(1);
        dict.setName("小陈");
        Map map = new HashMap();
        map.put("id", 1);
        map.put("name", "测试1");
        String params = JSON.toJSONString(map);
        log.warn("params {}",params);
//        redisTemplate.convertAndSend("test_topic", params);
        redisTemplate.convertAndSend("test_topic", dict);
    }
}
