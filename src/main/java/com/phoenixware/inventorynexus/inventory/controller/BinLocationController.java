package com.phoenixware.inventorynexus.inventory.controller;

import com.phoenixware.inventorynexus.inventory.dto.binlocation.BinLocationDTO;
import com.phoenixware.inventorynexus.inventory.service.BinLocationService;
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
public class BinLocationController {
    private final BinLocationService binLocationService;

    @GetMapping("/bin-locations/{id}")
    public ResponseEntity getBinLocation(UUID id) {
        BinLocationDTO binLocationDTO = binLocationService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/bin-locations/" + binLocationDTO.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                binLocationDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PutMapping("/bin-locations/{id}")
    public ResponseEntity putBinLocation(@PathParam("id") UUID id, @RequestBody BinLocationDTO binLocationDTO) {
        BinLocationDTO updatedBinLocationDto = binLocationService.updateById(id, binLocationDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/bin-locations/" + updatedBinLocationDto.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                updatedBinLocationDto,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PatchMapping("/bin-locations/{id}")
    public ResponseEntity patchBinLocation(@PathParam("id") UUID id, @RequestBody BinLocationDTO binLocationDTO) {
        BinLocationDTO patchedBinLocationDto = binLocationService.patchById(id, binLocationDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/bin-locations/" + patchedBinLocationDto);

        ResponseEntity responseEntity = new ResponseEntity(
                patchedBinLocationDto,
                httpHeaders,
                HttpStatus.ACCEPTED
        );

        return responseEntity;
    }

    @PostMapping("/bin-locations/")
    public ResponseEntity postBinLocation(@RequestBody BinLocationDTO binLocationDTO) {
        BinLocationDTO postedBinLocationDto = binLocationService.create(binLocationDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/bin-locations/" + postedBinLocationDto.getId());

        ResponseEntity responseEntity = new ResponseEntity(
                postedBinLocationDto,
                httpHeaders,
                HttpStatus.CREATED
        );

        return responseEntity;
    }

    @DeleteMapping("/bin-locations/{id}")
    public ResponseEntity deleteBinLocation(@PathParam("id") UUID id) {
        binLocationService.deleteById(id);

        ResponseEntity responseEntity = new ResponseEntity(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
