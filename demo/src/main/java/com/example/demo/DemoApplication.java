package com.example.demo;

import com.example.demo.DesignPattern.AbstractFactory.Color;
import com.example.demo.DesignPattern.AbstractfactoryImp;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication  //等同于 @ComponentScan、@Configuration和@EnableAutoConfiguration
//@ComponentScan  //扫描组件 @ComponentScan(value = "com.spriboot.controller") 配置扫描组件的路径
@MapperScan("com.example.demo.mybatis")
//@EnableScheduling
public class DemoApplication extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(DemoApplication.class);
//    }


    public static void main(String[] args) throws Exception {


        /*************************抽象工厂方式 ****************/
        // 工厂是抽象的 ，产品也是抽象的

        AbstractfactoryImp factory = new AbstractfactoryImp() ;
        //生成具体的工厂
        Color color = factory.generateColor("REDCOLOR");
        //生成具体产品
        color.fillWithColor();

        /*****************************************/

        SpringApplication.run(DemoApplication.class, args);
    }


   // Tomcat large file upload connection reset
//    @Bean
//    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
//            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
//                //-1 means unlimited
//                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
//            }
//        });
//        return tomcat;
//    }

    @Bean
    public TomcatServletWebServerFactory containerFactory() {
        return new TomcatServletWebServerFactory() {
            protected void customizeConnector(Connector connector) {
                int maxSize = -1;
                super.customizeConnector(connector);
                connector.setMaxPostSize(maxSize);
                connector.setMaxSavePostSize(maxSize);
                if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {

                    ((AbstractHttp11Protocol <?>) connector.getProtocolHandler()).setMaxSwallowSize(maxSize);
                    logger.info("Set MaxSwallowSize "+ maxSize);
                }
            }
        };

    }

}

//public class DemoApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }
//
//}
