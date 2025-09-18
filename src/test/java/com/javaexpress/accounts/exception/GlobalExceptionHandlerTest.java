package com.javaexpress.accounts.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalExceptionHandlerTest {

    private final GloablExceptionHandler exceptionHandler = new GloablExceptionHandler();

    @Test
    void testHandleCustomerAlreadyExistsException() {
        String message = "Customer already exists";
        CustomerAlreadyExistsException ex = new CustomerAlreadyExistsException(message);

        ErrorResponseDto response = exceptionHandler.handleException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getHttpStatus());
        assertEquals(message, response.getErrorMessage());
        assertNotNull(response.getLocalDateTime());
    }

    @Test
    void testHandleResourceNotFoundException() {
        String message = "Resource not found";
        ResourceNotFoundException ex = new ResourceNotFoundException(message);

        ErrorResponseDto response = exceptionHandler.handleException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getHttpStatus());
        assertEquals(message, response.getErrorMessage());
        assertNotNull(response.getLocalDateTime());
    }

    @Test
    void testHandleGenericException() {
        String message = "Something went wrong";
        Exception ex = new Exception(message);

        ErrorResponseDto response = exceptionHandler.handleException(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getHttpStatus());
        assertEquals(message, response.getErrorMessage());
        assertNotNull(response.getLocalDateTime());
    }
}
