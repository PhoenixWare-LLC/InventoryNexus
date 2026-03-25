package com.phoenixware.inventorynexus.inventory.controller;

import com.phoenixware.inventorynexus.inventory.dto.parentproduct.ParentProductDTO;
import com.phoenixware.inventorynexus.inventory.service.ParentProductService;
import jakarta.websocket.server.PathParam;
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
public class ParentProductController {
    private final ParentProductService parentProductService;

    @GetMapping("/parent-products/{id}")
    public ResponseEntity<ParentProductDTO> getParentProduct(@PathVariable("id") UUID id) {
        ParentProductDTO parentProductDTO = parentProductService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/parent-products/" + parentProductDTO.getId());

        ResponseEntity<ParentProductDTO> responseEntity = new ResponseEntity<>(
                parentProductDTO,
                httpHeaders,
                HttpStatus.OK
        );

        return responseEntity;
    }

    @PutMapping("/parent-products/{id}")
    public ResponseEntity<ParentProductDTO> putParentProduct(@PathParam("id") UUID id, @RequestBody ParentProductDTO parentProductDTO) {
        ParentProductDTO updatedParentProductDTO = parentProductService.updateById(id, parentProductDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/parent-products/" + updatedParentProductDTO.getId());

        ResponseEntity<ParentProductDTO> responseEntity = new ResponseEntity<>(
                updatedParentProductDTO,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/parent-products/{id}")
    public ResponseEntity<ParentProductDTO> patchParentProduct(@PathParam("id") UUID id, @RequestBody ParentProductDTO parentProductDTO) {
        ParentProductDTO patchedParentProductDTO = parentProductService.patchById(id, parentProductDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/parent-products/" + patchedParentProductDTO.getId());

        ResponseEntity<ParentProductDTO> responseEntity = new ResponseEntity<>(
                patchedParentProductDTO,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PostMapping("/parent-products")
    public ResponseEntity<ParentProductDTO> postParentProduct(@RequestBody ParentProductDTO parentProductDTO) {
        ParentProductDTO postedParentProductDto = parentProductService.create(parentProductDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/parent-products/" + postedParentProductDto.getId());

        ResponseEntity<ParentProductDTO> responseEntity = new ResponseEntity<>(
                postedParentProductDto,
                httpHeaders,
                HttpStatus.CREATED
        );

        return responseEntity;
    }

    @DeleteMapping("/parent-products/{id}")
    public ResponseEntity<ParentProductDTO> deleteParentProduct(@PathVariable("id") UUID id) {
        parentProductService.deleteById(id);

        ResponseEntity<ParentProductDTO> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
