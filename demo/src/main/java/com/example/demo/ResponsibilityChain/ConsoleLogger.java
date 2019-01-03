package com.example.demo.ResponsibilityChain;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.loggerLevel = level;
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
