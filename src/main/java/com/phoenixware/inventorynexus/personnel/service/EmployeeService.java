package com.phoenixware.inventorynexus.personnel.service;

import com.phoenixware.inventorynexus.personnel.dto.employee.EmployeeDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
public interface EmployeeService {
    EmployeeDTO create(EmployeeDTO employeeDTO);
    EmployeeDTO updateById(UUID id, EmployeeDTO employeeDTO);
    EmployeeDTO patchById(UUID id, EmployeeDTO employeeDTO);
    EmployeeDTO findById(UUID id);
    List<EmployeeDTO> findAll();
    void deleteById(UUID id);
}
