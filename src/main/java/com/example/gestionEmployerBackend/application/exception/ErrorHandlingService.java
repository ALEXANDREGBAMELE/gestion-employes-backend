package com.example.gestionEmployerBackend.application.exception;

import org.springframework.stereotype.Service;

@Service
public class ErrorHandlingService {

    public void handleResourceNotFound(Long id) {
        throw new ResourceNotFoundException("Resource with ID " + id + " not found.");
    }

 
    public void handleInvalidRequest(String message) {
        throw new InvalidRequestException("Invalid request: " + message);
    }
    
    public void handleServerError(String message) {
        throw new ServerErrorException("Server error: " + message);
    }

}
