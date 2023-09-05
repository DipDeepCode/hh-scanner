package ru.ddc.headhunter.core.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ItemConverter {

    private final ObjectMapper objectMapper;

    public ItemConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String convertToString(String pattern, Object object) {
        Map<String, Object> itemMap = objectMapper.convertValue(object, new TypeReference<>() {});
        return StringSubstitutor.replace(pattern, itemMap, "${", "}");
    }
}
