package com.example.demo.ResponsibilityChain;

/**
 *
 * interface 与 abstract class的区别
 * interface只能申明类，但是类中具体的行为，却是interface本身控制不了的，由遵循该协议的类决定，
 * 这样对于某些规则确定的业务，就没有办法控制了，
 * abstract class 与interface类似，但是它可以定义类中具体行为，这样对于一些需要定制规则的业务
 * 就比较理想了，规则写在abstract class中，数据由各个子类提供。
 *
 *
 *
 *
 */

public interface LoggerInterface {
}
