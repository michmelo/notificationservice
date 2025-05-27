package com.vitalconnect.notificationservice.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }

}
