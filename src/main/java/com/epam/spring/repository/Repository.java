package com.epam.spring.repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    Map<String, Object> repository = new HashMap<>();

    public Map<String, Object> getRepository() {
        return repository;
    }

    public void put(String key, Object object) {
        repository.put(key, object);
    }

    public void delete(String key) {
        repository.remove(key);
    }

    public Object get(String key) {
        return repository.remove(key);
    }
}
