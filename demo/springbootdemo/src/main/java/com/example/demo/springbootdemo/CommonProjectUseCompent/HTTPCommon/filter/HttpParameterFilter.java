package com.example.demo.springbootdemo.CommonProjectUseCompent.HTTPCommon.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;


public class HttpParameterFilter extends OncePerRequestFilter {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        logger.info("过滤器 before {} is 调用 ",this.getClass());

        Map<String, String[]> params = httpServletRequest.getParameterMap();

        filterChain.doFilter(httpServletRequest, httpServletResponse);

        logger.info("过滤器 after {} is 调用 ",this.getClass());
    }


    Map<String, String> convert(Map<String, String[]> inputMap){
        if (inputMap == null){
            return null;
        }

        Map<String, String> convertMap = new HashMap<>(8);
        for (String key: inputMap.keySet()) {
        }

        return null;
    }
}
