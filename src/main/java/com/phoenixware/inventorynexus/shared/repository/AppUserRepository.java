package com.phoenixware.inventorynexus.shared.repository;

import com.phoenixware.inventorynexus.shared.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query("""
                SELECT u
                FROM AppUser u
                LEFT JOIN FETCH u.userRoles r
                WHERE u.username = :username
            """)
    Optional<AppUser> findByUsernameWithRoles(@Param("username") String username);
    @Query("""
                SELECT u
                FROM AppUser u
                LEFT JOIN FETCH u.userPrivileges p
                WHERE u.id = :id
            """)
    Optional<AppUser> findByIdWithPrivileges(@Param("id") UUID id);
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
}
