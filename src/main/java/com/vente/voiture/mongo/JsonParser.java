package com.vente.voiture.mongo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    public static Map<String, Object> BuildJsonWithoutNullValue(String added, Object object){
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> completedMap = objectMapper.convertValue(object, new TypeReference<Map<String, Object>>(){});
        
        Map<String, Object> mapWithPrefix = new HashMap<>();
        Iterator<Map.Entry<String, Object>> iterator = completedMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            if (entry.getValue() != null && entry.getKey().contains("mdp") == false) {
                mapWithPrefix.put(added + entry.getKey(), entry.getValue());
            }
        }
        return mapWithPrefix;          
    }
    
}
