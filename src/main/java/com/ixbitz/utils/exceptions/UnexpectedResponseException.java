/*
 * Project: External-IP-Checker
 *
 * Author: Job Putters
 *
 */
package com.ixbitz.utils.exceptions;

/**
 * Exception to be thrown when an HttpRequest responds with an unexpected response
 *
 * @since 1.0-SNAPSHOT
 */
public class UnexpectedResponseException extends Exception {
    public UnexpectedResponseException() {
        super();
    }

    public UnexpectedResponseException(String message) {
        super(message);
    }

    public UnexpectedResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
