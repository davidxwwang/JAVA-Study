package com.example.demo.springbootdemo.CommonProjectUseCompent.validation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Service
public class Item2Impl implements Item2{

    @Override
    public String setName(@NotNull(message = "姓名不能为空") String name, String id) {
        return "david";
    }

    @Override
    public Long multiple(@Min(value = 0, message = "最小为0") Long id) {
        return id *2L;
    }
}
