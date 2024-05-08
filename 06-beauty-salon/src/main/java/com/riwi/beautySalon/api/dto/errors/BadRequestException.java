package com.riwi.beautySalon.api.dto.errors;

public class BadRequestException extends RuntimeException{
    public BadRequestException (String message){
        super(message);
    }
}
