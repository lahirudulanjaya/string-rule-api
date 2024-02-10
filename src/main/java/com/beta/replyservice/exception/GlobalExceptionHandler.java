package com.beta.replyservice.exception;

import com.beta.replyservice.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for handling various types of exceptions in the application.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles IllegalArgumentException and returns a response with status code 400 (Bad Request)
     *
     * @param illegalArgumentException exception that is handled by this method.
     * @return ResponseEntity containing the error response.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        return ResponseEntity.badRequest().body(new ErrorResponse(illegalArgumentException.getMessage()));
    }
}
