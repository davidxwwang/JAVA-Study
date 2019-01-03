package com.example.demo.CommandPattern;

/**
 * 命令,使用接口讲命令的发出者(调用者)，和命令本身分开
 */
public interface Order {
    public void execute();
}
