package com.booking.app.springboot_booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccommodationNotFoundException extends RuntimeException{
    public AccommodationNotFoundException(String message) {
        super(message);
    }
}
