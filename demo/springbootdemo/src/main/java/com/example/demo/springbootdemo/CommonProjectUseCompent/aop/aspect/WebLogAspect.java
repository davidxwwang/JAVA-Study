package com.example.demo.springbootdemo.CommonProjectUseCompent.aop.aspect;

import com.example.demo.springbootdemo.CommonProjectUseCompent.aop.MoniterUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.*;

@Component
@Aspect // 定义了一个切面
@Order(5) // 优先级，越小越高
public class WebLogAspect {

    //https://blog.csdn.net/bombsklk/article/details/79143145
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 通过@Pointcut定义的可重用的切入点为
    // com.example.demo.springbootdemo.CommonProjectUseCompent.validation.ValidationController
    // 下的所有函数（对web层所有请求处理做切入点）
    // ..*  匹配任意的类
    // .*   匹配任意的方法
    // (**) 匹配方法任意的入参
    // * com.example.XXX 前面的 * 表示任意类型的返回值
    @Pointcut("execution(public * com.example.demo.springbootdemo.CommonProjectUseCompent.validation.ValidationController.*(..))")
    public void weblog(){}

    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("请求的request.url：{}", request.getRequestURI());
        logger.info("请求的request paramter：{}", request.getParameterMap());
        logger.info("{}", joinPoint.getSignature());
        logger.info("入参{}", joinPoint.getArgs());
        logger.info("对象target{}", joinPoint.getTarget());

    }

    @Around("weblog()")
    public void doRound(ProceedingJoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Thread thread = Thread.currentThread();
        logger.info("当前线程为：{}", thread.toString());

        MoniterUtil.start();
        try{
            joinPoint.proceed(joinPoint.getArgs());

            MoniterUtil.finish();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
 //   @Around("execution(public * com.example.demo.CommonProjectUseCompent.validation..*.*(..)) && @annotation(DavidValid))")
//    @Before(value = "@annotation(com.example.demo.springbootdemo.CommonProjectUseCompent.validation.DavidValid)")
//    //  @Before("execution(public * ValidateTest.*.*(..)))")
//    public Object doeddde(JoinPoint joinPoint) throws Throwable{
//        Object[] args = joinPoint.getArgs();
//        return true;
//
//    }
}
