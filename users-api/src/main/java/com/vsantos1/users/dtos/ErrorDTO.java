package com.vsantos1.users.dtos;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.HashMap;

public class ErrorDTO {
    private final Date timestamp;
    private final String message;
    private final HashMap<String, String> errors;
    private final String path;

    private final HttpStatus status;

    public ErrorDTO(Date timestamp, String message, HashMap<String, String> errors, String path, HttpStatus status) {
        this.timestamp = timestamp;
        this.message = message;
        this.errors = errors;
        this.path = path;
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public String getPath() {
        return path;
    }

    public HttpStatus getStatus() {
        return status;
    }
}

