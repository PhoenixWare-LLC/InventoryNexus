package com.phoenixware.inventorynexus.shared.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class ContactNotFoundException extends RuntimeException{

    public ContactNotFoundException(String message) {
        super(message);
    }

    public ContactNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactNotFoundException(Throwable cause) {
        super(cause);
    }
    public ContactNotFoundException() {

    }

    public ContactNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
