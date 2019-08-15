package reflect;

import dtoObject.OptinalItemDTO;
import dtoObject.PersonDTO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {

    PersonDTO person ;

    public static PersonDTO test1(String id, Integer item, OptinalItemDTO itemDTO){

        return null;
    }



    public static void main(String[] args) {

        Class clazz = Reflect.class;
        Method[] methods =  clazz.getDeclaredMethods();

        Field[] fields = clazz.getDeclaredFields();



        System.out.print("");

    //    clazz.getDeclaredMethod();



    }


}
