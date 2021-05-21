package com.segagames.Sega_Rest_api.exceptions;

public class InvalidGameTransactionIdException extends RuntimeException{
    public InvalidGameTransactionIdException(String message) {
        super(message);
    }

}
