package com.stackroute.downstreamservice.exceptions;

public class EmployeeAlreadyExistsException extends  Exception {
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}