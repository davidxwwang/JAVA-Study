package com.example.demo.CommonProjectUseCompent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

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
        return SpringbootUtil.applicationContext.getBean(beanName);
    }
}
