package com.phoenixware.inventorynexus.orders.exception.minimalproduct;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class MinimalProductNotFoundException extends RuntimeException{

    public MinimalProductNotFoundException(String message) {
        super(message);
    }

    public MinimalProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MinimalProductNotFoundException(Throwable cause) {
        super(cause);
    }
    public MinimalProductNotFoundException() {

    }

    public MinimalProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
