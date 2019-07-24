package lambda;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class javaQueue {

    /**
     * 无界blockedQueue
     */
    static void testUnboundQueue(){

        LinkedBlockingQueue unboundBlockQueue = new LinkedBlockingQueue(1);

        // offer()方法不会阻塞当前线程，如果满了，当即就返回false
        boolean isOK_0 = unboundBlockQueue.offer("元素1");
        boolean isOK_1 = unboundBlockQueue.offer("元素2");
        boolean isOK_2 = unboundBlockQueue.offer("元素3");


//        try {
//            // put()方法会阻塞当前线程
//            unboundBlockQueue.put("元素1");
//            unboundBlockQueue.put("元素2");
//            unboundBlockQueue.put("元素3");
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    /**
     * 有界blockedQueue
     */
    static void testBoundQueue(){
        ArrayBlockingQueue boundBlockQueue =  new ArrayBlockingQueue(1);
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.print("step in thread----0\n");

                        Thread.sleep(1000,1);
                        System.out.print("step in thread----1\n");
                        String e = (String) boundBlockQueue.take();

                        System.out.print("before hello world:" + e + "\n\n");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // todo put()方法会阻塞
            boundBlockQueue.put("元素1");
            System.out.print("step0\n");

            thread.start();
            System.out.print("step1\n");

            boundBlockQueue.put("元素2");
            System.out.print("step2\n");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("end here!\n");

        /** 执行顺序
         * step0
         * step in thread----0
         * step1
         * step in thread----1
         * step2
         * end here!
         * before hello world:元素1
         */

        while (true);
    }

    public static void main(String[] args) {

        testUnboundQueue();

       // testBoundQueue();
    }
}
