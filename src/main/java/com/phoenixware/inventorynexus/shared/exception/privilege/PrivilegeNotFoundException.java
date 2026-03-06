package com.phoenixware.inventorynexus.shared.exception.privilege;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class PrivilegeNotFoundException extends RuntimeException{

    public PrivilegeNotFoundException(String message) {
        super(message);
    }

    public PrivilegeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrivilegeNotFoundException(Throwable cause) {
        super(cause);
    }
    public PrivilegeNotFoundException() {

    }

    public PrivilegeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
