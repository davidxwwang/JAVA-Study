package com.example.demo.ResponsibilityChain;

public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level){
        this.loggerLevel = level;
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println(" error::Logger: " + message);
    }
}
