package com.example.demo.Timer.DelayQueue;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

@Component
public class DelayQueueTest {


    public void test(){
        List<String> list = new ArrayList<String>();
        list.add("00000001");
        list.add("00000002");
        list.add("00000003");
        list.add("00000004");
        list.add("00000005");


        HashMap map = new HashMap();
        map.put("key", "david王");
        map.put("key2", "iphone-mx");

        // 非阻塞队列
        DelayQueue<OrderDelayTask> queue = new DelayQueue<OrderDelayTask>();
        long start = System.currentTimeMillis();
        for(int i = 0;i<5;i++){
            //延迟三秒取出
            queue.put(new OrderDelayTask(list.get(i),
                    TimeUnit.NANOSECONDS.convert(3, TimeUnit.SECONDS), map));

            try {
                queue.take().doSth();
                System.out.println("After " +
                        (System.currentTimeMillis()-start) + " MilliSeconds");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        int a = 10;
        int b = a;

    }


}
