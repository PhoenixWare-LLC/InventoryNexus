package com.phoenixware.inventorynexus.shared.repository;

import com.phoenixware.inventorynexus.shared.entity.AppUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/11/2026
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
    @EntityGraph(attributePaths = {"userRoles", "userPrivileges"})
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
}
