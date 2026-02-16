package com.phoenixware.inventorynexus.shared.dto;

import com.phoenixware.inventorynexus.shared.entity.Privilege;
import com.phoenixware.inventorynexus.shared.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDTO {
    private UUID id;
    private Set<Role> userRoles;
    private Set<Privilege> userPrivileges;
    private String email;
    private String username;
    private String password;
    private boolean active = false;
    private boolean admin = false;
    private String mfaType = "email";
    private LocalDateTime createdAt;
    private String createdBy;
}
