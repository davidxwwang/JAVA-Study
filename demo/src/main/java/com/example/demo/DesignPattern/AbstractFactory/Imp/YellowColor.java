package com.example.demo.DesignPattern.AbstractFactory.Imp;

import com.example.demo.DesignPattern.AbstractFactory.Color;

public class YellowColor implements Color {
    @Override
    public void fillWithColor() {
        System.out.println("Inside YellowColor::draw() method.");
    }
}
