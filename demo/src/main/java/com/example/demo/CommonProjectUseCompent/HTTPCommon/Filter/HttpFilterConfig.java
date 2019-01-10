package com.example.demo.CommonProjectUseCompent.HTTPCommon.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class HttpFilterConfig {

    @Bean
    public FilterRegistrationBean httpFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("davidHttpParamsFilter");
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setFilter(new DavidHttpFilter());
        return filterRegistrationBean;
    }
}
