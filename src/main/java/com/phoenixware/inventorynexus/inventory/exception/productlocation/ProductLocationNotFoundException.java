package com.phoenixware.inventorynexus.inventory.exception.productlocation;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class ProductLocationNotFoundException extends RuntimeException{

    public ProductLocationNotFoundException(String message) {
        super(message);
    }

    public ProductLocationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductLocationNotFoundException(Throwable cause) {
        super(cause);
    }
    public ProductLocationNotFoundException() {

    }

    public ProductLocationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
