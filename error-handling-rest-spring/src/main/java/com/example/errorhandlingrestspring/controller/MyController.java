package com.example.errorhandlingrestspring.controller;

import com.example.errorhandlingrestspring.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling RESTful API requests related to resources.
 */
@RestController
@RequestMapping("/api")
public class MyController {

    /**
     * Endpoint to greet the client with a "Hello, Spring Boot!" message.
     *
     * @return ResponseEntity with a 200 (OK) status code and the greeting message.
     */
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello, Spring Boot!");
    }

    /**
     * Endpoint to simulate a scenario where a resource with a specific ID is not found.
     *
     * @param id The ID of the requested resource.
     * @return ResponseEntity with a 404 (NOT_FOUND) status code and a message indicating resource not found.
     * @throws ResourceNotFoundException If the resource with the specified ID is not found.
     */
    @GetMapping("/resource/{id}")
    public ResponseEntity<String> getResource(@PathVariable Long id) {
        // Some business logic
        // If resource not found, throw a custom exception
        throw new ResourceNotFoundException("Resource with ID " + id + " not found");
    }
}
