package com.example.rpcdemo.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
public class CalculatorRPCRequest implements Serializable {

    private static final long serialVersionUID = -1L;

    @Setter
    @Getter
    private Integer a;

    @Setter
    @Getter
    private Integer b;

    @Setter
    @Getter
    private String method;
}
