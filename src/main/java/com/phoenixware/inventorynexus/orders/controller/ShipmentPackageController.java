package com.phoenixware.inventorynexus.orders.controller;

import com.phoenixware.inventorynexus.orders.dto.shipmentpackage.ShipmentPackageDTO;
import com.phoenixware.inventorynexus.orders.service.ShipmentPackageService;
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
public class ShipmentPackageController {
    private final ShipmentPackageService shipmentPackageService;

    @GetMapping("/shipment-packages/{id}")
    public ResponseEntity<ShipmentPackageDTO> getShipment(@PathVariable("id") UUID id) {
        ShipmentPackageDTO shipmentPackageDTO = shipmentPackageService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipment-packages/" + shipmentPackageDTO.getId());

        ResponseEntity<ShipmentPackageDTO> responseEntity = new ResponseEntity<>(
                shipmentPackageDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PutMapping("/shipment-packages/{id}")
    public ResponseEntity<ShipmentPackageDTO> updateShipment(@PathVariable("id") UUID id, @RequestBody ShipmentPackageDTO shipmentPackageDTO) {
        ShipmentPackageDTO updatedShipmentPackageDTO = shipmentPackageService.updateById(id, shipmentPackageDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipment-packages/" + updatedShipmentPackageDTO.getId());

        ResponseEntity<ShipmentPackageDTO> responseEntity = new ResponseEntity<>(
                updatedShipmentPackageDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PatchMapping("/shipment-packages/{id}")
    public ResponseEntity<ShipmentPackageDTO> patchShipment(@PathVariable("id") UUID id, @RequestBody ShipmentPackageDTO shipmentPackageDTO) {
        ShipmentPackageDTO patchedShipmentPackageDTO = shipmentPackageService.patchById(id, shipmentPackageDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipment-packages/" + patchedShipmentPackageDTO.getId());

        ResponseEntity<ShipmentPackageDTO> responseEntity = new ResponseEntity<>(
                patchedShipmentPackageDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PostMapping("/shipment-packages")
    public ResponseEntity<ShipmentPackageDTO> postShipment(@RequestBody ShipmentPackageDTO shipmentPackageDTO) {
        ShipmentPackageDTO postedShipmentPackageDTO = shipmentPackageService.create(shipmentPackageDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipment-packages/" + postedShipmentPackageDTO.getId());

        ResponseEntity<ShipmentPackageDTO> responseEntity = new ResponseEntity<>(
                postedShipmentPackageDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @DeleteMapping("/shipment-packages/{id}")
    public ResponseEntity<ShipmentPackageDTO> deleteShipment(@PathVariable("id") UUID id) {
        shipmentPackageService.deleteById(id);

        ResponseEntity<ShipmentPackageDTO> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
