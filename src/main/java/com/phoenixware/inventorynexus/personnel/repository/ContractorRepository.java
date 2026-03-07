package com.phoenixware.inventorynexus.personnel.repository;

import com.phoenixware.inventorynexus.personnel.entity.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
public interface ContractorRepository extends JpaRepository<Contractor, UUID> {
}
