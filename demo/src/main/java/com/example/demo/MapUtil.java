package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

    static HashMap merge(HashMap oldMap, HashMap newMap){

        if (oldMap == null || newMap == null){
            return null;
        }

        newMap.forEach((key, value)->{
            oldMap.merge(key, value, (oldValue, newValue)->{
                return newValue;
            });
        });

        return (HashMap)oldMap.clone();
    }

}
