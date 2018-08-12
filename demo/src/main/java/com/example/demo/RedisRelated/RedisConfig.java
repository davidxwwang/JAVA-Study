package com.example.demo.RedisRelated;

import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.util.concurrent.CountDownLatch;

@Configuration
public class RedisConfig {

    @Bean
    MessageListenerAdapter listenerAdapter() {
        return new MessageListenerAdapter(new MyRedisChannelListener());
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 加入自定义的 监听者类
        container.addMessageListener(new MyRedisChannelListener(), new PatternTopic("news*"));



        return container;
    }


}