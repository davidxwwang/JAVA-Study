package anotations.anotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Date;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = IsGanderValidImpl.class) // 指明自定义注解的实现类

public @interface CrossValid {

    String message() default "错误的性别标示";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


//    Date begin() default Date.parse("");
//    Date end() default ;

    String v1() default "";

    String v2() default "";

    /**
     *
     */
    @Target({ TYPE, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    public @interface List2 {
        CrossValid[] value();
    }
}
