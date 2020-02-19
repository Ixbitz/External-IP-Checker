/*
 * Project: External-IP-Checker
 *
 * COPYRIGHT: Copyright 2019 AMPLEXOR Netherlands.
 * All Rights Reserved.
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
