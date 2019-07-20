package com.example.demo.springbootdemo.CommonProjectUseCompent.HTTPCommon.interceptor;

import com.example.demo.springbootdemo.CommonProjectUseCompent.HTTPCommon.interceptor.access.AccessInterceptor;
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

    @Bean
    public AccessInterceptor getAccessInterceptor(){
        return new AccessInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.getDavidHttpInterceptor()).addPathPatterns("/valid/*");

        registry.addInterceptor(this.getAccessInterceptor());

    }
}
