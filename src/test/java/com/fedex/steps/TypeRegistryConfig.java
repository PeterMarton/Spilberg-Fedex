package com.fedex.steps;

import io.cucumber.java.ParameterType;
import util.NumberConverter;

public class TypeRegistryConfig {

    @ParameterType("\\S+")
    public int position(String index) {
        return NumberConverter.getMatchingIndex(index);
    }

}
