package com.phoenixware.inventorynexus.personnel.mapper;

import com.phoenixware.inventorynexus.personnel.dto.employee.EmployeeDTO;
import com.phoenixware.inventorynexus.personnel.entity.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
@Mapper
public interface EmployeeMapper {
    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee patchEmployeeFromEmployeeDto(EmployeeDTO employeeDTO, @MappingTarget Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EmployeeDTO patchEmployeeDtoFromEmployee(Employee employee, @MappingTarget EmployeeDTO employeeDTO);

    EmployeeDTO employeeToEmployeeDto(Employee employee);
}
