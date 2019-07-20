package com.example.demo.springbootdemo.CommonProjectUseCompent.HTTPCommon.interceptor.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 限流拦截器
public class AccessInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("拦截器 {} is called", this.getClass());

        if (handler instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod)handler;

            AccessLimit accessLimit = method.getMethodAnnotation(AccessLimit.class);
            // 无限流注解，放行
            if (accessLimit == null){
                return true;
            }

            // 使用redis 限流
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean needLogin = accessLimit.needLogin();

            if (needLogin){
                // todo get user
            }

            String key = request.getRequestURI();
            // 利用redis 控制流量

        }
        return true;
    }




    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
