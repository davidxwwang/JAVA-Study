package com.example.demo.DesignPattern.AbstractFactory;


/**
 * 一个抽象的工厂interface，可能对应着好几个具体的工厂，根据specficFactoryname生成不同的工厂
 *
 *
 */

public interface AbstractFactory {
    /**
     * 生成具体的工厂
     * @param specficFactoryname 具体工厂的名字
     * @return
     */
    Color generateColor(String specficFactoryname);

}
