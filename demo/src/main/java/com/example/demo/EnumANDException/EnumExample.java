package com.example.demo.EnumANDException;

public enum EnumExample {
     ENUM_EX_1(1,"david"),
     ENUM_EX_2(2,"xxxx");

    private Integer code;
    private String desc;

    EnumExample(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }
}
