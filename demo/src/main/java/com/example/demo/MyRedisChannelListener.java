package com.example.demo;


import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.io.UnsupportedEncodingException;


public class MyRedisChannelListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] channal = message.getChannel();
        byte[] bs = message.getBody();
        try{
            String content = new String(bs,"UTF-8");
            String p = new String(channal,"UTF-8");
            System.out.println("get " + content + " from " + p);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
