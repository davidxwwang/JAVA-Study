package com.example.demo.springbootdemo.CommonProjectUseCompent.HTTPCommon.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public DavidHttpInterceptor getDavidHttpInterceptor(){
        return new DavidHttpInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.getDavidHttpInterceptor()).addPathPatterns("/valid/*");

    }
}
