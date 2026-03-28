package com.phoenixware.inventorynexus.inventory.controller;

import com.phoenixware.inventorynexus.inventory.dto.product.ProductDTO;
import com.phoenixware.inventorynexus.inventory.service.ProductService;
import com.phoenixware.inventorynexus.shared.dto.baseproduct.BaseProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("@method_authorization.hasPrivilege(authentication, 'products', 'read')")
    public ResponseEntity<BaseProductDTO> getProduct(@PathVariable("id") UUID id) {
        BaseProductDTO baseProductDTO = productService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + baseProductDTO.getId());

        ResponseEntity<BaseProductDTO> responseEntity = new ResponseEntity<>(
                baseProductDTO,
                httpHeaders,
                HttpStatus.OK
        );

        return responseEntity;
    }

    @PutMapping("/products/{id}")
    @PreAuthorize("@method_authorization.hasPrivilege(authentication, 'products', 'update')")
    public ResponseEntity<BaseProductDTO> updateProduct(@PathVariable UUID id, @RequestBody ProductDTO productDTO) {
        BaseProductDTO updatedBaseProductDTO = productService.updateById(id, productDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + updatedBaseProductDTO.getId());

        ResponseEntity<BaseProductDTO> responseEntity = new ResponseEntity<>(
                updatedBaseProductDTO,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/products/{id}")
    @PreAuthorize("@method_authorization.hasPrivilege(authentication, 'products', 'update')")
    public ResponseEntity<BaseProductDTO> patchProduct(@PathVariable UUID id, @RequestBody ProductDTO productDTO) {
        BaseProductDTO patchedBaseProductDTO = productService.patchById(id, productDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + patchedBaseProductDTO.getId());

        ResponseEntity<BaseProductDTO> responseEntity = new ResponseEntity<>(
                patchedBaseProductDTO,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/products")
    @PreAuthorize("@method_authorization.hasPrivilege(authentication, 'products', 'create')")
    public ResponseEntity<BaseProductDTO> postProduct(@RequestBody ProductDTO productDTO) {
        BaseProductDTO postedBaseProduct = productService.create(productDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/products/" + postedBaseProduct.getId());

        ResponseEntity<BaseProductDTO> responseEntity = new ResponseEntity<>(
                postedBaseProduct,
                httpHeaders,
                HttpStatus.CREATED
        );

        return responseEntity;
    }

    @DeleteMapping("/products/{id}")
    @PreAuthorize("@method_authorization.hasPrivilege(authentication, 'products', 'delete')")
    public ResponseEntity<BaseProductDTO> deleteProduct(@PathVariable("id") UUID id) {
        productService.deleteById(id);

        ResponseEntity<BaseProductDTO> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
