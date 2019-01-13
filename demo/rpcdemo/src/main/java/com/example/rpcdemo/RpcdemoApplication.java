package com.example.rpcdemo;

import com.example.rpcdemo.provider.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static void main(String[] args) {
        Calculator calculator = new CalculatorRemoteImpl();
        int result = calculator.add(1, 2);
        log.info("result is {}", result);
    }
}

