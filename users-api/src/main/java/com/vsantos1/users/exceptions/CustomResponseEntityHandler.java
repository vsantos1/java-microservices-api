package com.vsantos1.users.exceptions;

import com.vsantos1.users.dtos.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;

@RestControllerAdvice
public class CustomResponseEntityHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {

        HashMap<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                "Validation error",
                HttpStatus.BAD_REQUEST,
                request.getRequestURI(),
                errors

        );


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, HttpServletRequest request) {
        HashMap<String, String> errors = new HashMap<>();


        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND, request.getRequestURI(), errors);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

    }

}
