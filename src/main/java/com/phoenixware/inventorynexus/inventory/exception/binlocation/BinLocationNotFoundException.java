package com.phoenixware.inventorynexus.inventory.exception.binlocation;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class BinLocationNotFoundException extends RuntimeException{

    public BinLocationNotFoundException(String message) {
        super(message);
    }

    public BinLocationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BinLocationNotFoundException(Throwable cause) {
        super(cause);
    }
    public BinLocationNotFoundException() {

    }

    public BinLocationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
