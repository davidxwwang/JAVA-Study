package com.example.demo.CommonProjectUseCompent.YMLFilters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FilterChainException extends Exception{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public FilterChainException(Class clazz, String msg){
        super(clazz.getName() + "exceptionMsg" + msg, null);
        logger.info(clazz.getName() + "exceptionMsg: {}{}", msg, msg);
    }

    public FilterChainException(){

    }
}
