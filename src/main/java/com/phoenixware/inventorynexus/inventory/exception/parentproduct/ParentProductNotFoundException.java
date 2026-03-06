package com.phoenixware.inventorynexus.inventory.exception.parentproduct;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class ParentProductNotFoundException extends RuntimeException{

    public ParentProductNotFoundException(String message) {
        super(message);
    }

    public ParentProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParentProductNotFoundException(Throwable cause) {
        super(cause);
    }
    public ParentProductNotFoundException() {

    }

    public ParentProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
