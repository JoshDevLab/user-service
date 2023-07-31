package com.example.userservice.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class CustomHandlerException {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handlerException(EmptyResultDataAccessException e) {
        HashMap<String, String> result = new HashMap<>();
        result.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
