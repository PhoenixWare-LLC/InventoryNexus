package com.phoenixware.inventorynexus.personnel.controller;

import com.phoenixware.inventorynexus.personnel.dto.contractor.ContractorDTO;
import com.phoenixware.inventorynexus.personnel.service.ContractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
@RestController
@RequiredArgsConstructor
public class ContractorController {
    private final ContractorService contractorService;

    @GetMapping("/shipments/{id}")
    public ResponseEntity<ContractorDTO> getShipment(@PathVariable("id") UUID id) {
        ContractorDTO contractorDTO = contractorService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipments/" + contractorDTO.getId());

        ResponseEntity<ContractorDTO> responseEntity = new ResponseEntity<>(
                contractorDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PutMapping("/shipments/{id}")
    public ResponseEntity<ContractorDTO> updateShipment(@PathVariable("id") UUID id, @RequestBody ContractorDTO contractorDTO) {
        ContractorDTO updatedContractorDTO = contractorService.updateById(id, contractorDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipments/" + updatedContractorDTO.getId());

        ResponseEntity<ContractorDTO> responseEntity = new ResponseEntity<>(
                updatedContractorDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PatchMapping("/shipments/{id}")
    public ResponseEntity<ContractorDTO> patchShipment(@PathVariable("id") UUID id, @RequestBody ContractorDTO contractorDTO) {
        ContractorDTO patchedContractorDTO = contractorService.patchById(id, contractorDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipments/" + patchedContractorDTO.getId());

        ResponseEntity<ContractorDTO> responseEntity = new ResponseEntity<>(
                patchedContractorDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PostMapping("/shipments")
    public ResponseEntity<ContractorDTO> postShipment(@RequestBody ContractorDTO contractorDTO) {
        ContractorDTO postedContractorDTO = contractorService.create(contractorDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/shipments/" + postedContractorDTO.getId());

        ResponseEntity<ContractorDTO> responseEntity = new ResponseEntity<>(
                postedContractorDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @DeleteMapping("/shipments/{id}")
    public ResponseEntity<ContractorDTO> deleteShipment(@PathVariable("id") UUID id) {
        contractorService.deleteById(id);

        ResponseEntity<ContractorDTO> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
