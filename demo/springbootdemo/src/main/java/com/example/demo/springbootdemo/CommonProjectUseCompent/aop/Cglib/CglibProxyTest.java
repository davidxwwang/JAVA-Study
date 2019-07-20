package com.example.demo.springbootdemo.CommonProjectUseCompent.aop.Cglib;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class CglibProxyTest {

    public static void main(String[] args) {
        new CglibProxyTest().doTest();
    }

    public void doTest(){

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        BookFacadeImpl1 Impl = new BookFacadeImpl1();
        BookFacadeCglib bookFacadeCglib = new BookFacadeCglib();

        // 代理对象
        BookFacadeImpl1 proxy = (BookFacadeImpl1) bookFacadeCglib.getInstance(Impl);
        proxy.addbooks();
       // Impl.addbooks();
       // Hashtable

    }

}
