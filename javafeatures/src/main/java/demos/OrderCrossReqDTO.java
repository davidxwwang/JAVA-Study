package demos;

import anotations.anotation.CrossValid;
import lombok.Data;


// 希望该DTO中v1 长度 大于 v2
@Data
@CrossValid(v1 = "xxx", v2 = "yyy")
public class OrderCrossReqDTO {

    String v1;

    String v2;
}
