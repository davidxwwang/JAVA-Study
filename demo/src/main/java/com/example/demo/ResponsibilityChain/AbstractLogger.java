package com.example.demo.ResponsibilityChain;

public abstract class AbstractLogger {
    // 假设 链 是由小到大传递的
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int loggerLevel;

    // 责任链下一个元素
    protected AbstractLogger nextLogger;


    abstract protected void writeMessage(String message);

    public AbstractLogger getNextLogger() {
        return nextLogger;
    }

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(String logMessage , int loggerLevel) {

        /**************** 这就是其子类都认的规则，当然这个规则是可以自定义的   ************/
        //若输入的级别高的时候，才一直传下去，负责没有必要：
        // 就像火警一样，小的火警就没有必要上传了
        if (loggerLevel >= this.loggerLevel){
            writeMessage(logMessage);

            if (nextLogger != null){
                nextLogger.log(logMessage ,loggerLevel);
            }
        }

    }

}
