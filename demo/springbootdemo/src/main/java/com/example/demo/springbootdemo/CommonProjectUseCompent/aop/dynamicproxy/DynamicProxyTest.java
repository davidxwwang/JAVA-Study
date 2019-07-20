package com.example.demo.springbootdemo.CommonProjectUseCompent.aop.dynamicproxy;

import sun.applet.AppletClassLoader;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

public class DynamicProxyTest {

    public static void main(String[] args) {
        new DynamicProxyTest().doTest();
    }

    static class OOObject{}


    void doTest(){
        try {
            String path = this.getClass().getClassLoader().getResources("").toString();
            System.out.print(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = "l am 君山";
        byte[] b;
        char[] charb = new char[s.length()];
        try {
             s.getChars(0,s.length(),charb,0);
             b = s.getBytes("GB2312");
            byte[] bb =b;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        List<OOObject> list = new ArrayList<>();
//        while (true){
//            list.add(new OOObject());
//        }

        // 一个学生
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
            // 班长代理名叫david的人去交钱
            studentProxy.getMoney();


        }catch (Exception ex){

        }

    }

}
