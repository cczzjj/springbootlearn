package com.chen.springbootlearn.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResultConverter {
    public String toString(Object value) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(value);
    }
}
