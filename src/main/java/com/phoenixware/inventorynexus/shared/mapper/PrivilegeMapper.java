package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.shared.dto.privilege.PrivilegeDTO;
import com.phoenixware.inventorynexus.shared.entity.Privilege;
import org.mapstruct.Mapper;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Mapper
public interface PrivilegeMapper {
    Privilege privilegeDtoToPrivilege(PrivilegeDTO privilegeDTO);

    PrivilegeDTO privilegeToPrivilegeDto(Privilege privilege);
}
