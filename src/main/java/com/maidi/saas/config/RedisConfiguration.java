package com.maidi.saas.config;

import com.maidi.saas.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by hongjian.chen on 2019/6/21.
 */

@Configuration
public class RedisConfiguration {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate redisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(this.redisConnectionFactory);
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        stringRedisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return stringRedisTemplate;
    }

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //订阅了一个叫chat的通道
        container.addMessageListener(listenerAdapter1(), new PatternTopic("test_topic"));
        container.addMessageListener(listenerAdapter2(), new PatternTopic("demo_topic"));
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter1() {
        //与channel1绑定的适配器,收到消息时执行RedisConsumer类中的consumeMsg方法
        return new MessageListenerAdapter(redisService, "consumeMsg");
    }

    @Bean
    public MessageListenerAdapter listenerAdapter2() {
        return new MessageListenerAdapter(redisService, "receiverMessage");
    }
}
