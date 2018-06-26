package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication  //等同于 @ComponentScan、@Configuration和@EnableAutoConfiguration
//@ComponentScan  //扫描组件 @ComponentScan(value = "com.spriboot.controller") 配置扫描组件的路径
//@MapperScan("com.example.demo.mybatis")
@EnableScheduling

public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner init(StorageService storageService) {
//        return (args) -> {
//            storageService.deleteAll();
//            storageService.init();
//        };
//    }
}
