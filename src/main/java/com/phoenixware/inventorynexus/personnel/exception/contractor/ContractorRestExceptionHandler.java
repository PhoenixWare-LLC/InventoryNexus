package com.phoenixware.inventorynexus.personnel.exception.contractor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Slf4j
@ControllerAdvice
public class ContractorRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ContractorExceptionResponse> handleException(ContractorNotFoundException exc) {
        // create an OrderNotFoundException

        ContractorExceptionResponse error = new ContractorExceptionResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(LocalDateTime.now());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ContractorExceptionResponse> handleException(Exception exc) {
        ContractorExceptionResponse error = new ContractorExceptionResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(LocalDateTime.now());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
