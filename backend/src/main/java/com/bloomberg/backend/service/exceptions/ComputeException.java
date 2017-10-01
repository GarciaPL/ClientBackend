package com.bloomberg.backend.service.exceptions;

public class ComputeException extends RuntimeException {

    public ComputeException(String message, Throwable cause) {
        super(message, cause);
    }
}
