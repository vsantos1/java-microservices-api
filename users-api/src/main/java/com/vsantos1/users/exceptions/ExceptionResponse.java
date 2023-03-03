package com.vsantos1.users.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class ExceptionResponse implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    private final Date timestamp;
    private final String message;
    private final HttpStatus status;
    private final String path;

    private final HashMap<String, String> errors;


    public ExceptionResponse(Date timestamp, String message, HttpStatus status, String path, HashMap<String, String> errors) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
        this.path = path;
        this.errors = errors;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status.value();
    }

    public String getPath() {
        return path;
    }
}
