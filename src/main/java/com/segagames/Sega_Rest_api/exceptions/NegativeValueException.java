package com.segagames.Sega_Rest_api.exceptions;

public class NegativeValueException extends RuntimeException{
    public NegativeValueException(String message) {
        super(message);
    }
}
