package com.mgoportfolio2022api.mgoportfolio2022api.error;

import com.mgoportfolio2022api.mgoportfolio2022api.error.exeption.BadRequestException;
import com.mgoportfolio2022api.mgoportfolio2022api.error.exeption.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestExceptionResponse> handleException( BadRequestException exc){
        RestExceptionResponse error = new RestExceptionResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException .class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<RestExceptionResponse> handleNotFoundException(NotFoundException   e){
        var error = new RestExceptionResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
