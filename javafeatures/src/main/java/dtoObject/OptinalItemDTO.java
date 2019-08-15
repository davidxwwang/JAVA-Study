package dtoObject;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Optional;

@Data
public class OptinalItemDTO {

    private Optional<String> storeID;

    private Optional<Integer> status;

    private Optional<Date> createdDate;

}
