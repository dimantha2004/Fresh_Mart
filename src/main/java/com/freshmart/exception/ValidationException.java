package com.freshmart.exception;

/**
 * Thrown whenever input or a business rule is violated. The message is written for the end
 * user, so the UI can show it directly in an alert without translating it.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message) { super(message); }
}
