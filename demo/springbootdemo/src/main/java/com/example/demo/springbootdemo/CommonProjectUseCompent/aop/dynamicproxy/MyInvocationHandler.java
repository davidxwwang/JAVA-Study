package com.example.demo.springbootdemo.CommonProjectUseCompent.aop.dynamicproxy;

import com.example.demo.springbootdemo.CommonProjectUseCompent.aop.MoniterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler<T> implements InvocationHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    T target;

    MyInvocationHandler(T target){
        if (target == null){
            return;
        }

        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        logger.info("执行代理方法{}",method.getName());

        MoniterUtil.start();

        Object object = method.invoke(target, args);

        MoniterUtil.finish();

        return object;
    }
}
