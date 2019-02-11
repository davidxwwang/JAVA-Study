package com.example.demo.springbootdemo.CommonProjectUseCompent.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoniterUtil {

    static Logger  logger = LoggerFactory.getLogger(MoniterUtil.class);

    private static ThreadLocal<Long> spendTime = new ThreadLocal<>();

    static void  start(){
        spendTime.set(System.currentTimeMillis());
    }

    static void finish(){
        Long now = System.currentTimeMillis();
        Long sessionTime = now - spendTime.get();

        logger.info("花去了：{} ms", sessionTime);

    }
}
