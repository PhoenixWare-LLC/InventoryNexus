package com.phoenixware.inventorynexus.inventory.controller;

import com.phoenixware.inventorynexus.inventory.dto.product.ProductDTO;
import com.phoenixware.inventorynexus.inventory.service.ProductService;
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
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity getProduct(@PathVariable("id") UUID id) {
        BaseProductDTO baseProductDTO = productService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + baseProductDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                baseProductDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PutMapping("/products/{id}")
    public ResponseEntity updateProduct(@PathVariable UUID id, @RequestBody ProductDTO productDTO) {
        BaseProductDTO updatedBaseProductDTO = productService.updateById(id, productDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + updatedBaseProductDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                updatedBaseProductDTO,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity patchProduct(@PathVariable UUID id, @RequestBody ProductDTO productDTO) {
        BaseProductDTO patchedBaseProductDTO = productService.patchById(id, productDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + patchedBaseProductDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                patchedBaseProductDTO,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/products")
    public ResponseEntity postProduct(@RequestBody ProductDTO productDTO) {
        BaseProductDTO postedBaseProduct = productService.create(productDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + postedBaseProduct.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                postedBaseProduct,
                httpHeaders,
                HttpStatus.CREATED
        );

        return responseEntity;
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id) {
        productService.deleteById(id);

        ResponseEntity responseEntity = new ResponseEntity(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
