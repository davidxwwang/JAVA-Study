
package reflect.dynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student implements Person{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String name;

    public Student(String name){
        this.name = name;
    }

    @Override
    public String getMoney(String name, Integer id) {
        logger.info("这个{}学生交学费了",this.name);
        return "一百块大洋保护费给你，班长！";
    }
}
