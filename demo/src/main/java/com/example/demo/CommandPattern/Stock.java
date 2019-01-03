package com.example.demo.CommandPattern;


/**
 * 该类就是具体的命令的执行者
 *
 *
 */
public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: " + name + ",Quantity:" + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: " + name + ",Quantity:" + quantity +" ] sell");
    }
}
