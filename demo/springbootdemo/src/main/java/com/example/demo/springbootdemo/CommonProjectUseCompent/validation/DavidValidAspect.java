//package com.example.demo.springbootdemo.CommonProjectUseCompent.validation;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.annotation.Validated;
//
//import java.util.function.ObjIntConsumer;
//
//@Aspect
//@Configuration
////@Order(10)
//public class DavidValidAspect {
//
//
//    // @Pointcut("execution(public * ValidateTest.*.*(..)))")
////    @Pointcut(value = "@annotation(DavidValid)")
////    public void webLog(){}
//
////    @Around("webLog()")
////    public Object dotest(ProceedingJoinPoint joinPoint){
////
////        Object[] args = joinPoint.getArgs();
////        return true;
////    }
//
//    @Before(value = "@annotation(com.example.demo.springbootdemo.CommonProjectUseCompent.validation.DavidValid)")
//  //  @Before("execution(public * ValidateTest.*.*(..)))")
//    public Object doeddde(JoinPoint joinPoint) throws Throwable{
//        Object[] args = joinPoint.getArgs();
//        return true;
//
//    }
//
////    @Around("execution(public * com.example.demo.CommonProjectUseCompent.validation..*.*(..)) && @annotation(DavidValid))")
////    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
////        Object[] args = joinPoint.getArgs();
////        return true;
//////        Result validate = ValidationUtils.validate(args);
//////        if (validate.isSuccess()) {
//////            return joinPoint.proceed();
//////        }
//////        return validate;
////    }
//}
