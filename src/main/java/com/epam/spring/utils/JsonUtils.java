package com.epam.spring.utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;

public class JsonUtils {

    public JsonUtils() {
    }

    public JsonNode parseJsonNode(File file) {
        try {
            return JsonHelper.getObjectMapper().readTree(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T getWrapper(JsonNode jsonNode, Class<T> item) {
        return JsonHelper.getObjectMapper().convertValue(jsonNode, item);
    }
}
