package com.example.demo.springbootdemo.CommonProjectUseCompent;

import com.example.demo.springbootdemo.CommonProjectUseCompent.validation.SpringbootdemoApplication;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(classes = {SpringbootdemoApplication.class})  //引入入口类的配置
@RunWith(SpringRunner.class)
public class SpringbootUtilTest {

    @Test
    public void getBean() {
        ClassLoader classLoader =  Thread.currentThread().getContextClassLoader();
        Class c2 = classLoader.getClass();
        Object object = SpringbootUtil.getBean("item2Impl"); // 不是 Item2Impl
        int x= 3;
        int y =x;

    }
}