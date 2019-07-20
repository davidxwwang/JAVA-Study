package com.example.demo.springbootdemo.CommonProjectUseCompent.customannomation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义参数校验注解
 * 校验 List 集合中是否有null 元素
 */

//@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Constraint(validatedBy = ListNotHasNullValidatorImpl.class)////此处指定了注解的实现类为ListNotHasNullValidatorImpl

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ListNotHasNullValidatorImpl.class)

public @interface ListNotHasNull {

    int value() default 0;

    String message() default "List中元素不能有把null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

//    /**
//     * 定义List，为了让Bean的一个属性上可以添加多套规则
//     */
//    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
//    @Retention(RUNTIME)
//    @Documented
//    @interface List {
//        ListNotHasNull[] value();
//    }

    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        ListNotHasNull[] value();
    }


}
