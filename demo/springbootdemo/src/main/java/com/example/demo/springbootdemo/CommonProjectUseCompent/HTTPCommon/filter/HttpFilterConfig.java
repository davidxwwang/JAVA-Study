package com.example.demo.springbootdemo.CommonProjectUseCompent.HTTPCommon.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

@Configuration
public class HttpFilterConfig {

    @Bean
    public FilterRegistrationBean davidHttpFilterRegistrationBean() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("davidHttpParamsFilter");
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setFilter(new DavidHttpFilter());
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean httpParameterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("httpParameterFilter");
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setFilter(new HttpParameterFilter());

        return filterRegistrationBean;
    }
}
