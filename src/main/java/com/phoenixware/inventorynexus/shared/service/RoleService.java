package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.role.RoleDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/12/26
 */
public interface RoleService {
    RoleDTO create(RoleDTO roleDTO);
    RoleDTO updateById(UUID id, RoleDTO roleDTO);
    RoleDTO patchById(UUID id, RoleDTO roleDTO);
    RoleDTO findById(UUID id, RoleDTO roleDTO);
    List<RoleDTO> findAll();
    void deleteById(UUID id);
}
