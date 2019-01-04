package com.example.demo.CommonProjectUseCompent.YMLFilters;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class FilterChainContext {

    @Setter
    @Getter
    private Map<String, Object> contextMap = new HashMap<>();
}
