package com.example.demo.DesignPattern;

import com.example.demo.DesignPattern.AbstractFactory.AbstractFactory;
import com.example.demo.DesignPattern.AbstractFactory.Color;
import com.example.demo.DesignPattern.AbstractFactory.Imp.RedColor;
import com.example.demo.DesignPattern.AbstractFactory.Imp.YellowColor;

import java.lang.reflect.Method;

/**
 * 实现 抽象工厂的方法
 */
public class AbstractfactoryImp implements AbstractFactory {

    @Override
    public Color generateColor(String specficFactoryname) {
        if (specficFactoryname == null){
            return null;
        }

        Class face = this.getClass();
        Class[] xx = face.getInterfaces();
        Method[] yy = face.getMethods();
        Package dd = face.getPackage();


        if (specficFactoryname.equalsIgnoreCase("REDCOLOR")){
            return new RedColor();
        }else if (specficFactoryname.equalsIgnoreCase("YELLOWCOLOR")){
            return new YellowColor();
        }

        return null;
    }
}
