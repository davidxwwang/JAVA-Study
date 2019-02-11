package com.example.demo.springbootdemo.CommonProjectUseCompent.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student implements Person{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String name;

    public Student(String name){
        this.name = name;
    }

    @Override
    public void getMoney() {

        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        logger.info("这个{}学生交学费了",this.name);

    }
}
