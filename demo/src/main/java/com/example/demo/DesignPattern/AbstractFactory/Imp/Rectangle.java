package com.example.demo.DesignPattern.AbstractFactory.Imp;

import com.example.demo.DesignPattern.AbstractFactory.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
