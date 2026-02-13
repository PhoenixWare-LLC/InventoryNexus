package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.shared.dto.RoleDTO;
import com.phoenixware.inventorynexus.shared.entity.Role;
import org.mapstruct.Mapper;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Mapper
public interface RoleMapper {
    Role roleDtoToRole(RoleDTO roleDTO);

    RoleDTO roleToRoleDto(Role role);
}
