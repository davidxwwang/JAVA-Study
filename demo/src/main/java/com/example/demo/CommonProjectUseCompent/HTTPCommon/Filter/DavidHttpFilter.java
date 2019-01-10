package com.example.demo.CommonProjectUseCompent.HTTPCommon.Filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

public class DavidHttpFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        filterChain.doFilter(httpServletRequest, httpServletResponse);

       // byte[] originalBytes = (HttpServletResponse)httpServletResponse.getOutputStream().

        String demo = "david";
        byte[] bytes = demo.getBytes("UTF-8");
        String demo2 = new String(bytes, Charset.forName("UTF-8"));
        httpServletResponse.getOutputStream().write(bytes);
    }
}
