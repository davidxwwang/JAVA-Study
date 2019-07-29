package lambda;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class javaQueue {

    /**
     * 无界blockedQueue
     * todo 既然提供了LinkedBlockingQueue 为什么还要提供ConcurrentLinkedQueue ???!!!
     */
    static void testUnboundQueue(){

        // capacity写了就是有界的，不写，就是无界限的（下面是容量为1的有界限queue）
        LinkedBlockingQueue unboundBlockQueue = new LinkedBlockingQueue(1);

        // offer()方法不会阻塞当前线程，如果满了，当即就返回false
//        boolean isOK_0 = unboundBlockQueue.offer("元素1");
//        boolean isOK_1 = unboundBlockQueue.offer("元素2");
//        boolean isOK_2 = unboundBlockQueue.offer("元素3");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    // 启动新线程后，睡眠1000ms
                    Thread.sleep(1000,0);

                    String value= (String) unboundBlockQueue.take();
                    System.out.print("\n得到数据=" + value + "\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        try {
            // put()方法会阻塞当前线程
            unboundBlockQueue.put("元素1");

            thread.start();
          //  thread.interrupt(); 线程会报InterruptedException

            // todo 如果unboundBlockQueue中的元素不被take掉，永远都put不进去
            unboundBlockQueue.put("元素2");


            System.out.print("\nqueue中数据：" + unboundBlockQueue.toArray().length);
            System.out.print("\n启动了一个新的线程");


            unboundBlockQueue.put("元素3");

            System.out.print("\n恐怕这句话永远都打印不出来了");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
