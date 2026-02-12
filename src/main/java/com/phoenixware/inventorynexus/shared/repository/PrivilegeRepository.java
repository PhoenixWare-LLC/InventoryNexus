package com.phoenixware.inventorynexus.shared.repository;

import com.phoenixware.inventorynexus.shared.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/11/2026
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, UUID> {
}
