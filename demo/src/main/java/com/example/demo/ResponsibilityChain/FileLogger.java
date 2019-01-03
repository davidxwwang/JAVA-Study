package com.example.demo.ResponsibilityChain;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.loggerLevel = level;
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println(" File::Logger: " + message);
    }
}
