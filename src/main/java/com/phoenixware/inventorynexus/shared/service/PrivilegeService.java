package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.privilege.PrivilegeDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/12/26
 */
public interface PrivilegeService {
    PrivilegeDTO create(PrivilegeDTO privilegeDTO);
    PrivilegeDTO updateById(UUID id, PrivilegeDTO privilegeDTO);
    PrivilegeDTO patchById(UUID id, PrivilegeDTO privilegeDTO);
    PrivilegeDTO findById(UUID id);
    List<PrivilegeDTO> findAll();
    void deleteById(UUID id);
}
