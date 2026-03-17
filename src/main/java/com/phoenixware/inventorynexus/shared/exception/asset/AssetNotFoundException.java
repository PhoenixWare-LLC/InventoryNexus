package com.phoenixware.inventorynexus.shared.exception.asset;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class AssetNotFoundException extends RuntimeException{

    public AssetNotFoundException(String message) {
        super(message);
    }

    public AssetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssetNotFoundException(Throwable cause) {
        super(cause);
    }
    public AssetNotFoundException() {

    }

    public AssetNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
