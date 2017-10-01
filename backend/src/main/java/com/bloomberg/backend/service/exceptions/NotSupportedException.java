package com.bloomberg.backend.service.exceptions;

public class NotSupportedException extends RuntimeException {

    public NotSupportedException(String message) {
        super(message);
    }
}
