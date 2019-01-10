package com.example.demo.MutliThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(){
        logger.info("david:  正在执行" + Thread.currentThread().getName());

    }

}
