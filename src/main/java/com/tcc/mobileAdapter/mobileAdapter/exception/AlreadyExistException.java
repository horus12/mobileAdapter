package com.tcc.mobileAdapter.mobileAdapter.exception;

public class AlreadyExistException extends Exception {

    public AlreadyExistException() {
        super();
    }


    public AlreadyExistException(String message) {
        super(message);
    }


    public AlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}