package com.segagames.Sega_Rest_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException apiRequestException){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException =   new ApiException(apiRequestException.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException,badRequest);
    }

    @ExceptionHandler(value = {InvalidGameTransactionIdException.class})
    public ResponseEntity<Object> handleInvalidGameTransactionIdException(InvalidGameTransactionIdException invalidGameTransactionIdException){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException =   new ApiException(invalidGameTransactionIdException.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException,badRequest);
    }


    @ExceptionHandler(value = {NegativeValueException.class})
    public ResponseEntity<Object> handleNegativeTransactionIdNumberException(NegativeValueException negativeValueException){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException =   new ApiException(negativeValueException.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException,badRequest);
    }

}
