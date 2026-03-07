package com.phoenixware.inventorynexus.shared.exception.appuser;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class AppUserNotFoundException extends RuntimeException{

    public AppUserNotFoundException(String message) {
        super(message);
    }

    public AppUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppUserNotFoundException(Throwable cause) {
        super(cause);
    }
    public AppUserNotFoundException() {

    }

    public AppUserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
