package com.example.errorhandlingrestspring;

import com.example.errorhandlingrestspring.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling exceptions thrown from controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles exceptions of type ResourceNotFoundException.
     *
     * @param ex The ResourceNotFoundException instance.
     * @return ResponseEntity with a 404 (NOT_FOUND) status code and the exception message in the response body.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Handles general exceptions (instances of Exception).
     *
     * @param ex The Exception instance.
     * @return ResponseEntity with a 500 (INTERNAL_SERVER_ERROR) status code and a generic error message in the response body.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }
}
