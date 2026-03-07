package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.shared.dto.privilege.PrivilegeDTO;
import com.phoenixware.inventorynexus.shared.dto.privilege.PrivilegeDetailedDTO;
import com.phoenixware.inventorynexus.shared.entity.Privilege;
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
public interface PrivilegeMapper {
    Privilege privilegeDtoToPrivilege(PrivilegeDTO privilegeDTO);
    Privilege privilegeDetailedDtoToPrivilege(PrivilegeDetailedDTO privilegeDetailedDTO);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Privilege patchPrivilegeFromPrivilegeDto(PrivilegeDTO privilegeDTO, @MappingTarget Privilege privilege);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PrivilegeDTO patchPrivilegeDtoFromPrivilege(Privilege privilege, @MappingTarget PrivilegeDTO privilegeDTO);

    PrivilegeDTO privilegeToPrivilegeDto(Privilege privilege);
    PrivilegeDetailedDTO privilegeToPrivilegeDetailedDto(Privilege privilege);


}
