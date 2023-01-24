package com.icloud.execption;

public class UnknownFileTypeException extends RuntimeException {
    public UnknownFileTypeException(final String message) {
        super(message);
    }
}
