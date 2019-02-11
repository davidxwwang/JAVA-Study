package com.example.rpcdemo;

import com.example.rpcdemo.provider.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//@SpringBootApplication
//public class RpcdemoApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(RpcdemoApplication.class, args);
//    }
//
//}

public class RpcdemoApplication {
    private static Logger log = LoggerFactory.getLogger(RpcdemoApplication.class);

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IntrospectionException {
//        Calculator calculator = new CalculatorRemoteImpl();
//        int result = calculator.add(1, 2);

        DavidProxy proxy = new DavidProxy();
        //绑定该类实现的所有接口
        Calculator calculator = (Calculator) proxy.bind(new CalculatorRemoteImpl());
        int result = calculator.add(1, 2);


        log.info("result is {}", result);

//        Class clazz = calculator.getClass();
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field field : fields) {
//            String key = field.getName();
//            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
//            Method method = descriptor.getReadMethod();
//            Object value = method.invoke(calculator);
//
//            System.out.println(key + ":" + value);
//
//        }

    }
}

