
package com.example.gestionEmployerBackend.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service pour gérer les logs d'erreur.
 */
@Service
public class LoggingService {

    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void logError(String context, Exception ex) {
        logger.error("Context: {}, Error: {}", context, ex.getMessage());
    }

    public void logWarning(String context, String message) {
        logger.warn("Context: {}, Warning: {}", context, message);
    }
}
