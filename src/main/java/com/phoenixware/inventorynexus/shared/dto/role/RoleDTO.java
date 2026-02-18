package com.phoenixware.inventorynexus.shared.dto.role;

import com.phoenixware.inventorynexus.shared.entity.AppUser;
import com.phoenixware.inventorynexus.shared.entity.Privilege;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Data
@Builder
public class RoleDTO {
    private UUID id;
    private Set<AppUser> appUsers;
    private Set<Privilege> rolePrivileges;
    private String name;
}
