package com.microservices.learning.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {

        super("Resource Not found on class ! ");
    
    }

    public ResourceNotFoundException(String message){

        super(message);

    }


}