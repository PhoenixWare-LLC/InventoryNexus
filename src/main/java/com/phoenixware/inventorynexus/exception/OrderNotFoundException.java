package com.phoenixware.inventorynexus.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderNotFoundException(Throwable cause) {
        super(cause);
    }
}
