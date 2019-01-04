package com.example.demo.CommonProjectUseCompent;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public abstract class CommonBaseReqDTO implements Serializable {

    @Getter
    @Setter
    private String userId;
}
