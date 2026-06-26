package com.example.demo.exception;

public class DataProcessingException extends RuntimeException {
    public DataProcessingException(String message, Throwable thr) {
        super(message, thr);
    }
}
