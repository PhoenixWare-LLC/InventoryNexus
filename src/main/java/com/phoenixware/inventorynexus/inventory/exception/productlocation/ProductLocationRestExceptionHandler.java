package com.phoenixware.inventorynexus.inventory.exception.productlocation;

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
public class ProductLocationRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProductLocationExceptionResponse> handleException(ProductLocationNotFoundException exc) {
        // create an OrderNotFoundException

        ProductLocationExceptionResponse error = new ProductLocationExceptionResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(LocalDateTime.now());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductLocationExceptionResponse> handleException(Exception exc) {
        ProductLocationExceptionResponse error = new ProductLocationExceptionResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(LocalDateTime.now());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
