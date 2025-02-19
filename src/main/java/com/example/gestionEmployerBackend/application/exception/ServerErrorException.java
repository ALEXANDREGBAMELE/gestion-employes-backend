package com.example.gestionEmployerBackend.application.exception;


public class ServerErrorException extends RuntimeException {
    public ServerErrorException(String message) {
        super(message);
    }
}
