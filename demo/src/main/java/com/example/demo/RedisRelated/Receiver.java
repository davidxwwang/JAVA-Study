package com.example.demo.RedisRelated;

import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        latch.countDown();

//        Class<?> c = null;
//        try {
//            c = Class.forName("class");
//            Constructor<?> con = c.getConstructors(String.class,int.class);
//            Receiver p = (Receiver) c.newInstance();
//        }catch (Exception e){
//            // todo
//        }
    }
}