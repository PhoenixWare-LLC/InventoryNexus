package com.phoenixware.inventorynexus.shared.dto.privilege;

import com.phoenixware.inventorynexus.shared.entity.AppUser;
import com.phoenixware.inventorynexus.shared.entity.Role;
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
public class PrivilegeDTO {
    private UUID id;
    private Set<Role> roles;
    private Set<AppUser> appUsers;
    private String name;
    private String resourceName;
    private boolean readPrivilege = false;
    private boolean writePrivilege = false;
    private boolean updatePrivilege = false;
    private boolean deletePrivilege = false;
}
