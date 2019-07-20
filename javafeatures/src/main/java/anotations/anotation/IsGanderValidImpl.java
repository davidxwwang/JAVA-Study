package anotations.anotation;

import anotations.group.Group1;
import anotations.group.Group2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class IsGanderValidImpl implements ConstraintValidator<IsGanderValid, Integer> {

    /**
     * 验证注解的groups，以便对元素分组校验
     */
    Class<?>[] groups;

    public void initialize(IsGanderValid constraintAnnotation) {

        groups = constraintAnnotation.groups();

    }

    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if (groups == null || groups.length == 0){
            return false;
        }

        // value 为null 由@Notnull判断
        if (Arrays.asList(groups).contains(Group1.class)){
            return (value == 1 || value == 2);
        }else if (Arrays.asList(groups).contains(Group2.class)){
            return (value == null ||  value == 1 || value == 2 || value == 3);
        }
        return false;
    }

}
