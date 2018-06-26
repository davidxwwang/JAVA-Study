package com.example.demo.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {
    @Autowired
    private MessagesSender messagesSender;

    @GetMapping(value = "/rabbit")
    void rabbitHello(){
        messagesSender.send();
    }

}
