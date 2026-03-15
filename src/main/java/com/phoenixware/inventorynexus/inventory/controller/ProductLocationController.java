package com.phoenixware.inventorynexus.inventory.controller;

import com.phoenixware.inventorynexus.inventory.dto.productlocation.ProductLocationDTO;
import com.phoenixware.inventorynexus.inventory.service.ProductLocationService;
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
public class ProductLocationController {    
    private final ProductLocationService productLocationService;

    @GetMapping("/product-locations/{id}")
    public ResponseEntity getProductLocation(@PathVariable("id") UUID id) {
        ProductLocationDTO productLocationDTO = productLocationService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + productLocationDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                productLocationDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PutMapping("/product-locations/{id}")
    public ResponseEntity updateProductLocation(@PathVariable UUID id, @RequestBody ProductLocationDTO productLocationDTO) {
        ProductLocationDTO updatedProductLocationDTO = productLocationService.updateById(id, productLocationDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + updatedProductLocationDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                updatedProductLocationDTO,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/product-locations/{id}")
    public ResponseEntity patchProductLocation(@PathVariable UUID id, @RequestBody ProductLocationDTO productLocationDTO) {
        ProductLocationDTO patchedProductLocationDTO = productLocationService.patchById(id, productLocationDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + patchedProductLocationDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                patchedProductLocationDTO,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/product-locations")
    public ResponseEntity postProductLocation(@RequestBody ProductLocationDTO productLocationDTO) {
        ProductLocationDTO postedProductLocationDTO = productLocationService.create(productLocationDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + postedProductLocationDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                postedProductLocationDTO,
                httpHeaders,
                HttpStatus.CREATED
        );

        return responseEntity;
    }

    @DeleteMapping("/product-locations/{id}")
    public ResponseEntity deleteProductLocation(@PathVariable("id") UUID id) {
        productLocationService.deleteById(id);

        ResponseEntity responseEntity = new ResponseEntity(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
