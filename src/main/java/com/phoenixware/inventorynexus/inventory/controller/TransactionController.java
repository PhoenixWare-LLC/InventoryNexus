package com.phoenixware.inventorynexus.inventory.controller;

import com.phoenixware.inventorynexus.inventory.dto.transaction.TransactionDTO;
import com.phoenixware.inventorynexus.inventory.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@RestController
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/transactions/{id}")
    public ResponseEntity getProductLocation(@PathVariable("id") UUID id) {
        TransactionDTO transactionDTO = transactionService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + transactionDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                transactionDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity updateProductLocation(@PathVariable UUID id, @RequestBody TransactionDTO transactionDTO) {
        TransactionDTO updatedTransactionDTO = transactionService.updateById(id, transactionDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + updatedTransactionDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                updatedTransactionDTO,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/transactions/{id}")
    public ResponseEntity patchProductLocation(@PathVariable UUID id, @RequestBody TransactionDTO transactionDTO) {
        TransactionDTO patchedTransactionDTO = transactionService.patchById(id, transactionDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + patchedTransactionDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                patchedTransactionDTO,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/transactions")
    public ResponseEntity postProductLocation(@RequestBody TransactionDTO transactionDTO) {
        TransactionDTO postedTransactionDTO = transactionService.create(transactionDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + postedTransactionDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                postedTransactionDTO,
                httpHeaders,
                HttpStatus.CREATED
        );

        return responseEntity;
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity deleteProductLocation(@PathVariable("id") UUID id) {
        transactionService.deleteById(id);

        ResponseEntity responseEntity = new ResponseEntity(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
