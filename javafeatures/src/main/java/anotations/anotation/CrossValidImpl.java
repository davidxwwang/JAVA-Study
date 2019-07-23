package anotations.anotation;

import dtoObject.OrderCrossReqDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CrossValidImpl implements ConstraintValidator<CrossValid, OrderCrossReqDTO> {

    /**
     * 验证注解的groups，以便对元素分组校验
     */
    Class<?>[] groups;

    String v1;

    String v2;

    public void initialize(CrossValid constraintAnnotation) {

        groups = constraintAnnotation.groups();

        v1 = constraintAnnotation.v1();

        v2 = constraintAnnotation.v2();

    }

    public boolean isValid(OrderCrossReqDTO value, ConstraintValidatorContext context) {

        String s1 = value.getV1();
        String s2 = value.getV2();

        // do your validation here
        return false;
    }
}
