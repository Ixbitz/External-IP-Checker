/*
 * Project: External-IP-Checker
 *
 * Author: Job Putters
 *
 */
package com.ixbitz.utils.exceptions;

/**
 * Exception to be thrown when something unexpected occurs during an HttpRequest
 *
 * @since 1.0-SNAPSHOT
 */
public class HttpException extends Exception {
    public HttpException() {
        super();
    }

    public HttpException(String message) {
        super(message);
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
    }
}
