package com.example.rpcdemo.provider;

public class CalculatorImpl implements Calculator{
    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }
}
