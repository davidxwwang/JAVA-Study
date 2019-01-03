package com.example.demo.Timer.DelayQueue;

import java.util.HashMap;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

//        优点:效率高,任务触发时间延迟低。
//        缺点:(1)服务器重启后，数据全部消失，怕宕机
//           (2)集群扩展相当麻烦
//           (3)因为内存条件限制的原因，比如下单未付款的订单数太多，那么很容易就出现OOM异常
//           (4)代码复杂度较高

public class OrderDelayTask implements Delayed {

    private HashMap data;
    private String orderId;
    private long timeout;


    OrderDelayTask(String orderId, long timeout, HashMap dataHashMap){
        this.data = dataHashMap;
        this.orderId = orderId;
        this.timeout = timeout + System.nanoTime();

    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        if (other == this)
            return 0;
        OrderDelayTask t = (OrderDelayTask) other;
        long d = (getDelay(TimeUnit.NANOSECONDS) - t
                .getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    public void doSth(){
        System.out.println(orderId+"编号的订单要删除啦。。。。");
    }

}
