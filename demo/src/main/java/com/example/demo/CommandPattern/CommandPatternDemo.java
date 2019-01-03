package com.example.demo.CommandPattern;

public class CommandPatternDemo {

    public static void main(String[] args) {
        // 具体的命令
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.addOrder(buyStockOrder);
        broker.addOrder(sellStockOrder);

        broker.placeOrders();
    }

}
