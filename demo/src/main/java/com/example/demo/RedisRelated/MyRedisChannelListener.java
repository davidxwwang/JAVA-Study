package com.example.demo.RedisRelated;


import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

public class MyRedisChannelListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] channal = message.getChannel();
        byte[] bs = message.getBody();
        try{
            String content = new String(bs,"UTF-8");
            String p = new String(channal,"UTF-8");
            System.out.println("Redis Message received get " + content + " from " + p);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
