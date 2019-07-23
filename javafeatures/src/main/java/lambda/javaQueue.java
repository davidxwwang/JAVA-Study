package lambda;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class javaQueue {


    static void testQueue(){
        ArrayBlockingQueue queue =  new ArrayBlockingQueue(1);
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.print("step in thread----0\n");

                        Thread.sleep(1000,1);
                        System.out.print("step in thread----1\n");
                        String e = (String) queue.take();

                        System.out.print("before hello world:" + e + "\n\n");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            queue.put("元素1");
            System.out.print("step0\n");

            thread.start();
            System.out.print("step1\n");

            queue.put("元素2");
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

        testQueue();
    }
}
