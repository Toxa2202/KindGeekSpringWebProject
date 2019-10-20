package com.saint.anthony.ryanairspringweb.exceptions;

public class WrongInputDataException extends RuntimeException {
    public WrongInputDataException(String message) {
        super(message);
    }
}
