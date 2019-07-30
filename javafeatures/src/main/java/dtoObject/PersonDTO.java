package dtoObject;


import anotations.anotation.IsGanderValid;
import anotations.group.Group1;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 测试anotation
 */
@ToString
public class PersonDTO {

    /**
     * 性别
     * group1下 不能为null，且只能是0（男性） 1（女性）
     * group1下 可以为null，如果不为null，且只能是0（男性） 1（女性）或 2 （其他）
     */
    @NotNull(message = "性别不能为空", groups = {Group1.class})
    @IsGanderValid.List2({@IsGanderValid(groups = {Group1.class}),@IsGanderValid(groups = {Group1.class})})
    @Getter
    @Setter
    Integer gander;

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    String hometown;

    @Override
    public int hashCode() {
        int code = super.hashCode();
        return code;
    }
}
