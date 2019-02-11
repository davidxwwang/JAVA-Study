package com.example.demo.springbootdemo.CommonProjectUseCompent.aop;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {


    void doTest(){

        Person david = new Student("david");

        InvocationHandler invocationHandler = new MyInvocationHandler<Person>(david);
        Class<?> studentClassProxy = Proxy.getProxyClass(
                Person.class.getClassLoader(), new Class<?>[] {Person.class});

        try{

            /**
             * 代理对象持有一个InvocationHandler对象，InvocationHandler对象持有一个被代理的对象
             */

            Constructor<?> constructor = studentClassProxy.getConstructor(InvocationHandler.class);

            // 学生的代理，即班长(动态生成的),动态创建的
            Person studentProxy = (Person) constructor.newInstance(invocationHandler);

            studentProxy.getMoney();


        }catch (Exception ex){

        }

    }



}
