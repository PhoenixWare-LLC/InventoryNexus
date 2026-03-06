package com.phoenixware.inventorynexus.personnel.exception.contractor;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class ContractorNotFoundException extends RuntimeException{

    public ContractorNotFoundException(String message) {
        super(message);
    }

    public ContractorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContractorNotFoundException(Throwable cause) {
        super(cause);
    }
    public ContractorNotFoundException() {

    }

    public ContractorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
