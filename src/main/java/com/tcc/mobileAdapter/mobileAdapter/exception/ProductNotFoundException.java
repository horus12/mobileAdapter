package com.tcc.mobileAdapter.mobileAdapter.exception;

import java.util.HashMap;
import java.util.Map;

public class ProductNotFoundException extends BaseException {
    public ProductNotFoundException() {
        super();
    }


    public ProductNotFoundException(String message) {
        super(message);
    }


    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
