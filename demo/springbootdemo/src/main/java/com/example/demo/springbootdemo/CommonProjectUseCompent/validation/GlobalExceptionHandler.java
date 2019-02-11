package com.example.demo.springbootdemo.CommonProjectUseCompent.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    @ExceptionHandler //(value = BindException.class)
    public String httpException(HttpServletRequest request, BindException ex){
        List<ObjectError> errors = ex.getAllErrors();

        return "david--error";
    }
}
