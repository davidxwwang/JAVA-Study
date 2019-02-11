package com.example.rpcdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DavidProxy implements InvocationHandler {

    private Object bindObject;

    public Object bind(Object bindObject){
        this.bindObject = bindObject;
        //绑定该类实现的所有接口，取得代理类
        return Proxy.newProxyInstance(bindObject.getClass().getClassLoader(),
                bindObject.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;//被代理的类型为Object基类
        //这里就可以进行所谓的AOP编程了
        //在调用具体函数方法前，执行功能处理
        result = method.invoke(bindObject,args);
        //在调用具体函数方法后，执行功能处理
        return result;

    }
}
