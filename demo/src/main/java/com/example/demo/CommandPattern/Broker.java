package com.example.demo.CommandPattern;

import java.util.LinkedList;
import java.util.List;

/**
 * 命令的调用者
 */
public class Broker {
    private List<Order> ordersList = new LinkedList<Order>();

    void addOrder(Order order){
        ordersList.add(order);
    }

    /**
     * 调用命令，这里使用interface的好处就在于，不需要知道具体类里面执行的细节，只管接口就可
     */
    void placeOrders(){
        for (Order order:ordersList) {
            order.execute();
        }
    }
}
