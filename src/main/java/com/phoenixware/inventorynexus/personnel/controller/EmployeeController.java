package com.phoenixware.inventorynexus.personnel.controller;

import com.phoenixware.inventorynexus.personnel.dto.employee.EmployeeDTO;
import com.phoenixware.inventorynexus.personnel.service.EmployeeService;
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
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getShipment(@PathVariable("id") UUID id) {
        EmployeeDTO employeeDTO = employeeService.findById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/employees/" + employeeDTO.getId());

        ResponseEntity<EmployeeDTO> responseEntity = new ResponseEntity<>(
                employeeDTO,
                httpHeaders,
                HttpStatus.OK
        );

        return responseEntity;
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> updateShipment(@PathVariable("id") UUID id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployeeDTO = employeeService.updateById(id, employeeDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/employees/" + updatedEmployeeDTO.getId());

        ResponseEntity<EmployeeDTO> responseEntity = new ResponseEntity<>(
                updatedEmployeeDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PatchMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> patchShipment(@PathVariable("id") UUID id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO patchedEmployeeDTO = employeeService.patchById(id, employeeDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/employees/" + patchedEmployeeDTO.getId());

        ResponseEntity<EmployeeDTO> responseEntity = new ResponseEntity<>(
                patchedEmployeeDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> postShipment(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO postedEmployeeDTO = employeeService.create(employeeDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/employees/" + postedEmployeeDTO.getId());

        ResponseEntity<EmployeeDTO> responseEntity = new ResponseEntity<>(
                postedEmployeeDTO,
                httpHeaders,
                HttpStatus.FOUND
        );

        return responseEntity;
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> deleteShipment(@PathVariable("id") UUID id) {
        employeeService.deleteById(id);

        ResponseEntity<EmployeeDTO> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );

        return responseEntity;
    }
}
