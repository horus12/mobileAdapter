package com.tcc.mobileAdapter.mobileAdapter.exception;

import java.util.HashMap;
import java.util.Map;

public class BaseException extends Exception{
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException() {
        super();
    }

    public Map<String, String> exceptionErrorMessage() {
        Map<String, String> map = new HashMap<>();
        map.put("error", getMessage());
        return map;
    }
}
