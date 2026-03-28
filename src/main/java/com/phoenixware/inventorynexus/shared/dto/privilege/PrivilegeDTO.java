package com.phoenixware.inventorynexus.shared.dto.privilege;

import com.phoenixware.inventorynexus.shared.entity.AppUser;
import com.phoenixware.inventorynexus.shared.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class PrivilegeDTO {
    private UUID id;
    private Set<Role> roles;
    private Set<AppUser> appUsers;
    private String name;
    private String resourceName;
    private Boolean readPrivilege = false;
    private Boolean writePrivilege = false;
    private Boolean updatePrivilege = false;
    private Boolean deletePrivilege = false;
}
