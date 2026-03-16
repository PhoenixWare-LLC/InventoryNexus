package com.phoenixware.inventorynexus.orders.controller;

import com.phoenixware.inventorynexus.orders.dto.minimalproduct.MinimalProductDTO;
import com.phoenixware.inventorynexus.orders.service.MinimalProductService;
import com.phoenixware.inventorynexus.shared.dto.baseproduct.BaseProductDTO;
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
public class MinimalProductController {
    private final MinimalProductService minimalProductService;

    @GetMapping("/minimal-products/{id}")
    public ResponseEntity<BaseProductDTO> getMinimalProduct(@PathVariable("id") UUID id) {
        BaseProductDTO minimalProduct = minimalProductService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/minimal-products/" + minimalProduct.getId());

        ResponseEntity<BaseProductDTO> responseEntity = new ResponseEntity<>(
                minimalProduct,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PutMapping("/minimal-products/{id}")
    public ResponseEntity<BaseProductDTO> updateMinimalProduct(@PathVariable("id") UUID id, @RequestBody MinimalProductDTO minimalProductDTO) {
        BaseProductDTO updatedMinimalProduct = minimalProductService.updateById(id, minimalProductDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/minimal-products/" + minimalProductDTO.getId());

        ResponseEntity<BaseProductDTO> responseEntity = new ResponseEntity<>(
                updatedMinimalProduct,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/minimal-products/{id}")
    public ResponseEntity<BaseProductDTO> patchMinimalProduct(@PathVariable("id") UUID id, @RequestBody MinimalProductDTO minimalProductDTO) {
        BaseProductDTO patchedMinimalProduct = minimalProductService.patchById(id, minimalProductDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/minimal-products/" + minimalProductDTO.getId());

        ResponseEntity<BaseProductDTO> responseEntity = new ResponseEntity<>(
                patchedMinimalProduct,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PostMapping("/minimal-products")
    public ResponseEntity<BaseProductDTO> postMinimalProduct(@RequestBody MinimalProductDTO minimalProductDTO) {
        BaseProductDTO postedMinimalProduct = minimalProductService.create(minimalProductDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/minimal-products/" + minimalProductDTO.getId());

        ResponseEntity<BaseProductDTO> responseEntity = new ResponseEntity<>(
                postedMinimalProduct,
                httpHeaders,
                HttpStatus.CREATED
        );

        return responseEntity;
    }

    @DeleteMapping("/minimal-products/{id}")
    public ResponseEntity<BaseProductDTO> deleteMinimalProduct(@PathVariable("id") UUID id) {
        minimalProductService.deleteById(id);

        ResponseEntity<BaseProductDTO> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
