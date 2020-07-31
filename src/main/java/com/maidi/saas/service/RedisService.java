package com.maidi.saas.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author hongjian.chen
 * @date 2020/7/31 13:39
 */
@Service
@Slf4j
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void pushMsg(String topic, JSONObject map) {
        redisTemplate.convertAndSend(topic, map);
    }

    public void consumeMsg(String msg) {
        System.out.println("---------------分割线----------------");
        System.out.println(msg);
//        JSONObject jsonObject = JSONObject.parseObject(msg);

    }

    public void receiverMessage(String msg) {
        log.warn("msg {}", msg);
//        JSONObject jsonObject = JSONObject.parseObject(msg);

    }
}