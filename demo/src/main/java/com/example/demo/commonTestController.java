package com.example.demo;

import com.example.demo.EnumANDException.EnumExample;
import com.example.demo.GirlOperation.Girl;
import com.example.demo.Timer.DelayQueue.DelayQueueTest;
import com.sun.xml.internal.bind.v2.model.core.EnumConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class commonTestController {

    @Autowired
    DelayQueueTest delayQueueTest;

    // 根据id查找女生
    @GetMapping(value = "/delayTask")
    public String delayTask(@PathVariable("id") Integer id){
        delayQueueTest.test();

        Integer code = EnumExample.ENUM_EX_1.getCode();
        String  desc = EnumExample.ENUM_EX_1.getDesc();

        return "";
    }

    // 根据年龄查找女生
}
