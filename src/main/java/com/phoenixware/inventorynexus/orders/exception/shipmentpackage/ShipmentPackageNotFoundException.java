package com.phoenixware.inventorynexus.orders.exception.shipmentpackage;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class ShipmentPackageNotFoundException extends RuntimeException{

    public ShipmentPackageNotFoundException(String message) {
        super(message);
    }

    public ShipmentPackageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShipmentPackageNotFoundException(Throwable cause) {
        super(cause);
    }
    public ShipmentPackageNotFoundException() {

    }

    public ShipmentPackageNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
