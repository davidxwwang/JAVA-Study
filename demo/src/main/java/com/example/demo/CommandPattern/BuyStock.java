package com.example.demo.CommandPattern;

public class BuyStock implements Order {
    private Stock stock;

    public BuyStock(Stock stock){
        this.stock = stock;

    }

    @Override
    public void execute() {
        try{
            stock.buy();
        }catch (Exception e){
            // todo
        }

    }
}
