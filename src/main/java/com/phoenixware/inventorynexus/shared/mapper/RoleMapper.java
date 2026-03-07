package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.shared.dto.role.RoleDTO;
import com.phoenixware.inventorynexus.shared.dto.role.RoleDetailedDTO;
import com.phoenixware.inventorynexus.shared.entity.Role;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Mapper
public interface RoleMapper {
    Role roleDtoToRole(RoleDTO roleDTO);
    Role roleDetailedDtoToRole(RoleDetailedDTO roleDetailedDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role patchRoleFromRoleDto(RoleDTO roleDTO, @MappingTarget Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RoleDTO patchRoleDtoFromRole(Role role, @MappingTarget RoleDTO roleDTO);

    RoleDTO roleToRoleDto(Role role);
    RoleDetailedDTO roleToRoleDetailedDto(Role role);
}
