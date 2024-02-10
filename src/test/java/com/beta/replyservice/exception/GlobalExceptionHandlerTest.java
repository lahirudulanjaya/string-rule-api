package com.beta.replyservice.exception;

import com.beta.replyservice.response.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    public void testHandleIllegalArgumentException_forTheGivenIllegalArgumentException_shouldReturnCorrectResponseEntity() {
        globalExceptionHandler = new GlobalExceptionHandler();
        String exceptionMessage = "Invalid Parameter";
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(exceptionMessage);

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgumentException(illegalArgumentException);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(exceptionMessage, response.getBody().getMessage());
    }

}