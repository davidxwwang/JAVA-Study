package com.example.demo.DesignPattern.AbstractFactory.Imp;

import com.example.demo.DesignPattern.AbstractFactory.Color;

public class RedColor implements Color {

    @Override
    public void fillWithColor() {
        System.out.println("Inside RedColor::draw() method.");
    }
}
