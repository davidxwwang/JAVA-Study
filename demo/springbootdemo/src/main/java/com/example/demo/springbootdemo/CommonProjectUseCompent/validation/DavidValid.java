package com.example.demo.springbootdemo.CommonProjectUseCompent.validation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface DavidValid {

    Class<?> [] group = {};

}

