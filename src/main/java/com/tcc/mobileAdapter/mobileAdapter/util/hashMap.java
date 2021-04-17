package com.tcc.mobileAdapter.mobileAdapter.util;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class hashMap {
    public Map<String, String> mapStatus(HttpStatus status){
        Map<String, String> map = new java.util.HashMap<>();
        map.put("Hello", "world");
        return map;
    }
}
