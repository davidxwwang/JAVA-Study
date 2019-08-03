package corcurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {


    public static void testLock(){
        Semaphore semaphore =new Semaphore(10);

        CountDownLatch countDownLatch = new CountDownLatch(3);
    }


    public static void main (String[] args){


    }
}
