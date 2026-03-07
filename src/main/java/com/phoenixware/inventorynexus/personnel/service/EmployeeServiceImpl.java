package com.phoenixware.inventorynexus.personnel.service;

import com.phoenixware.inventorynexus.personnel.dto.employee.EmployeeDTO;
import com.phoenixware.inventorynexus.personnel.entity.Employee;
import com.phoenixware.inventorynexus.personnel.exception.employee.EmployeeNotFoundException;
import com.phoenixware.inventorynexus.personnel.mapper.EmployeeMapper;
import com.phoenixware.inventorynexus.personnel.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        return employeeMapper.employeeToEmployeeDto(
                employeeRepository.save(
                        employeeMapper.employeeDtoToEmployee(
                                employeeDTO
                        )
                )
        );
    }

    @Override
    public EmployeeDTO updateById(UUID id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);

        Employee updatedEmployee = employeeMapper.employeeDtoToEmployee(employeeDTO);
        updatedEmployee.setId(id);

        employeeRepository.save(updatedEmployee);

        Employee employeeFromDb = employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);

        return employeeMapper.employeeToEmployeeDto(employeeFromDb);
    }

    @Override
    public EmployeeDTO patchById(UUID id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);

        Employee patchedEmployee = employeeMapper.patchEmployeeFromEmployeeDto(employeeDTO, existingEmployee);

        employeeRepository.save(patchedEmployee);

        Employee employeeFromDb = employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);

        return employeeMapper.employeeToEmployeeDto(employeeFromDb);
    }

    @Override
    public EmployeeDTO findById(UUID id) {
        return employeeMapper.employeeToEmployeeDto(
                employeeRepository.findById(id)
                        .orElseThrow(EmployeeNotFoundException::new)
        );
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository
                .findAll()
                .stream()
                .map(employeeMapper::employeeToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeNotFoundException();
        }
    }
}
