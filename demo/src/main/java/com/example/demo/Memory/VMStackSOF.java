package com.example.demo.Memory;

import java.util.concurrent.atomic.AtomicInteger;

public class VMStackSOF {

    public int stackLength = 1;

    private Integer stackLength2 = 2;

    // 内存泄漏 memory overflow
    void overflow(){

        Thread currentThead = Thread.currentThread();
        Thread.activeCount();
       // Thread.yield();

//        try {
//            stackLength2.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            currentThead.join();
//            Thread currentThead2 = Thread.currentThread();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        stackLength++;
        overflow();
        /**
         * catch (Exception ex) 根本抓不到
         */
//        try{
//            overflow();
//        }catch (Exception ex){
//            System.out.print(stackLength );
//        }
    }
}

