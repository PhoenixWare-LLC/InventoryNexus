package com.phoenixware.inventorynexus.orders.exception.orderitem;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class OrderItemNotFoundException extends RuntimeException{

    public OrderItemNotFoundException(String message) {
        super(message);
    }

    public OrderItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderItemNotFoundException(Throwable cause) {
        super(cause);
    }
    public OrderItemNotFoundException() {

    }

    public OrderItemNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
