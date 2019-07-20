package com.example.demo.springbootdemo.CommonProjectUseCompent.HTTPCommon.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 过滤器
 */
public class DavidHttpFilter extends OncePerRequestFilter {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        logger.info("过滤器 before {} is 调用 ",this.getClass());

        filterChain.doFilter(httpServletRequest, httpServletResponse);

       // byte[] originalBytes = (HttpServletResponse)httpServletResponse.getOutputStream().

        String name = DavidHttpFilter.class.getName();
        byte[] bytes = name.getBytes("UTF-8");
        String demo2 = new String(bytes, Charset.forName("UTF-8"));

        httpServletResponse.getOutputStream().write(bytes);
        httpServletResponse.setContentLength(100);

        logger.info("过滤器 after {} is 调用 ",this.getClass());
    }
}
