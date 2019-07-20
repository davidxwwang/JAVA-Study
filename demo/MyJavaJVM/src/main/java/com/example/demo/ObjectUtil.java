package com.example.demo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;

public class ObjectUtil {

    static public void setFieldValueByName(Object o, String field, Object value){
        try {
            String fieldFirstLetter = field.substring(0,1).toUpperCase();
            String setter = "set" + fieldFirstLetter + field.substring(1);
            Method method = o.getClass().getMethod(setter, value.getClass());
            method.invoke(o, value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
