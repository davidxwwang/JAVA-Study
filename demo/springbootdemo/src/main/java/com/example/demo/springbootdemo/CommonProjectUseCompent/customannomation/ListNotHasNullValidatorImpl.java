package com.example.demo.springbootdemo.CommonProjectUseCompent.customannomation;

import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * 自定义注解ListNotHasNull 的实现类
 * 用于判断List集合中是否含有null元素
 */
@Service
public class ListNotHasNullValidatorImpl implements ConstraintValidator<ListNotHasNull, List> {

    private int value;

    @Override
    public void initialize(ListNotHasNull constraintAnnotation) {
        this.value = constraintAnnotation.value();

    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext context) {
        for (Object object: list){
            if (object == null){ return false; }
        }

        return true;
    }
}
