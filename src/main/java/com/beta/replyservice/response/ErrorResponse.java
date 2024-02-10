package com.beta.replyservice.response;

/**
 * Represents an error response for REST APIs.
 */
public class ErrorResponse {

    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
