package com.phoenixware.inventorynexus.inventory.exception.transaction;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class TransactionNotFoundException extends RuntimeException{

    public TransactionNotFoundException(String message) {
        super(message);
    }

    public TransactionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionNotFoundException(Throwable cause) {
        super(cause);
    }
    public TransactionNotFoundException() {

    }

    public TransactionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
