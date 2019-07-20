package com.example.demo.springbootdemo.CommonProjectUseCompent.HTTPCommon.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 拦截器
 */
public class DavidHttpInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        logger.info("拦截器 {} is 调用 ",this.getClass());

        String requestUrl = request.getRequestURI();
        if (requestUrl.indexOf("david") == -1){
            String failStr = "david 可不是乱请求的  ";
            try {
                byte[] b = failStr.getBytes("UTF-8");
                response.getOutputStream().write(b);
                response.setContentType("UTF-8");
                response.setContentLength(100);
               // response.getWriter().print(b);
            } catch (UnsupportedEncodingException ex){

            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }
}
