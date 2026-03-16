package com.phoenixware.inventorynexus.orders.controller;

import com.phoenixware.inventorynexus.orders.dto.shipment.ShipmentDTO;
import com.phoenixware.inventorynexus.orders.service.ShipmentService;
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
public class ShipmentController {
    private final ShipmentService shipmentService;

    @GetMapping("/shipments/{id}")
    public ResponseEntity<ShipmentDTO> getShipment(@PathVariable("id") UUID id) {
        ShipmentDTO shipmentDTO = shipmentService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipments/" + shipmentDTO.getId());

        ResponseEntity<ShipmentDTO> responseEntity = new ResponseEntity<>(
                shipmentDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PutMapping("/shipments/{id}")
    public ResponseEntity<ShipmentDTO> updateShipment(@PathVariable("id") UUID id, @RequestBody ShipmentDTO shipmentDTO) {
        ShipmentDTO updatedShipmentDTO = shipmentService.updateById(id, shipmentDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipments/" + updatedShipmentDTO.getId());

        ResponseEntity<ShipmentDTO> responseEntity = new ResponseEntity<>(
                updatedShipmentDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PatchMapping("/shipments/{id}")
    public ResponseEntity<ShipmentDTO> patchShipment(@PathVariable("id") UUID id, @RequestBody ShipmentDTO shipmentDTO) {
        ShipmentDTO patchedShipmentDTO = shipmentService.patchById(id, shipmentDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipments/" + patchedShipmentDTO.getId());

        ResponseEntity<ShipmentDTO> responseEntity = new ResponseEntity<>(
                patchedShipmentDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PostMapping("/shipments")
    public ResponseEntity<ShipmentDTO> postShipment(@RequestBody ShipmentDTO shipmentDTO) {
        ShipmentDTO postedShipmentDTO = shipmentService.create(shipmentDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipments/" + postedShipmentDTO.getId());

        ResponseEntity<ShipmentDTO> responseEntity = new ResponseEntity<>(
                postedShipmentDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @DeleteMapping("/shipments/{id}")
    public ResponseEntity<ShipmentDTO> deleteShipment(@PathVariable("id") UUID id) {
        shipmentService.deleteById(id);

        ResponseEntity<ShipmentDTO> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
