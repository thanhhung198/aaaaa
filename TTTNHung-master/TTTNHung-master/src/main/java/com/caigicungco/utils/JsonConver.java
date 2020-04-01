package com.caigicungco.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonConver {
    private String value;

    public JsonConver(String value) {
        this.value = value;
    }

    public <T> T toObject(Class<T> zClass){
        try {
            return new ObjectMapper().readValue(value, zClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
