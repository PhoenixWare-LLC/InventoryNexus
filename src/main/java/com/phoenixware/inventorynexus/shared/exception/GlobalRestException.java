package com.phoenixware.inventorynexus.shared.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class GlobalRestException extends RuntimeException{

    public GlobalRestException(String message) {
        super(message);
    }

    public GlobalRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalRestException(Throwable cause) {
        super(cause);
    }
    public GlobalRestException() {

    }

    public GlobalRestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
