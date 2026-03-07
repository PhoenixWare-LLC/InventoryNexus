package com.phoenixware.inventorynexus.personnel.repository;

import com.phoenixware.inventorynexus.personnel.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
