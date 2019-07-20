package com.example.demo.springbootdemo.CommonProjectUseCompent.aop.Cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;

// https://www.cnblogs.com/ygj0930/p/6542259.html
// 是被代理的子类

public class BookFacadeCglib implements MethodInterceptor {

    // /业务类对象，供代理方法中进行真正的业务方法调用
    private Object target;

    public Object getInstance(Object object){
        this.target = object;

        Enhancer enhancer = new Enhancer(); //创建加强器，用来创建动态代理类

        //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        enhancer.setSuperclass(this.target.getClass());
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return enhancer.create();

    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("david预处理——————\n");

        methodProxy.invokeSuper(o, args); //调用业务类（父类中）的方法

        System.out.println("\n调用后操作——————");

        return null;
    }
}
