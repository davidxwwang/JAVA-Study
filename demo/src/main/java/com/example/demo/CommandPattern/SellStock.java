package com.example.demo.CommandPattern;

public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock){
        this.stock = stock;
    }

    @Override
    public void execute() {
        try{
            stock.sell();
        }catch (Exception e){
            // todo
        }

    }
}
