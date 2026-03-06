package com.phoenixware.inventorynexus.shared.exception;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
public class ContactExceptionResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ContactExceptionResponse() {

    }

    public ContactExceptionResponse(int status, String message, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
