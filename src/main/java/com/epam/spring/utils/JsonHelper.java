package com.epam.spring.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.apache.log4j.helpers.LogLog.error;

/**
 * Represents JsonHelper to configure ObjectMapper.
 */
public class JsonHelper {

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            error("Error while converting to JSON", e);
            return "";
        }
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

}
