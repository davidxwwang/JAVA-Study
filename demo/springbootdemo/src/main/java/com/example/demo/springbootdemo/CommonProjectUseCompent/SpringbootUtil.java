package com.example.demo.springbootdemo.CommonProjectUseCompent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringbootUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringbootUtil.applicationContext == null){
            SpringbootUtil.applicationContext = applicationContext;
        }
    }

    public static Object getBean(String beanName){
        if (beanName == null){
            return null;
        }
        ApplicationContext context = SpringbootUtil.applicationContext;
        return context.getBean(beanName);
    }
}
