package anotations.anotation;

import anotations.group.Group1;
import anotations.group.Group2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class IsItemValidImpl implements ConstraintValidator<IsItemsValid, Object> {

    /**
     * 验证注解的groups，以便对元素分组校验
     */
    Class<?>[] groups;

    public void initialize(IsItemsValid constraintAnnotation) {
        groups = constraintAnnotation.groups();

    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if (groups == null || groups.length == 0){
            return false;
        }

        // 对同一个元素，分组校验
        if (Arrays.asList(groups).contains(Group1.class)){
            // todo 可以根据 value值，返回 true/false
            return true;
        }else if (Arrays.asList(groups).contains(Group2.class)) {
            // todo 可以根据 value值，返回 true/false
            return false;
        }else {
            return false;
        }
    }
}
