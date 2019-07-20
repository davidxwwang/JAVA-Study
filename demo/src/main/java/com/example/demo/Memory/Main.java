package com.example.demo.Memory;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static class OOMObject{
    }


    public static void main(String[] args){

       // leak();

        VMStackSOF sof = new VMStackSOF();
        try{
            sof.overflow();
        }catch (Throwable ex){
            System.out.print(sof.stackLength );
        }


    }



    // 内存溢出 memory leak
    // java.lang.OutOfMemoryError: Java heap space
    // 内存被申请完了，没有一丁点内存可以继续申请了。
    static void leak(){
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }


}
