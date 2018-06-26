package com.example.demo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component

public class MessagesSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        for (int i = 0;i<10;i++){
            String context = "hello -----" + String.valueOf(i) + " ----"; // new Date()
            System.out.println("Sender : " + context);
            // s: 队列
            this.rabbitTemplate.convertAndSend("hellodavid", context);

        }
    }
}
