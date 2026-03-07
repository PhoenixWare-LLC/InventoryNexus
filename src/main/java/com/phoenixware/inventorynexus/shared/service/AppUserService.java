package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.appuser.AppUserDTO;
import com.phoenixware.inventorynexus.shared.dto.appuser.AppUserDetailedDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/12/26
 */
public interface AppUserService {
    AppUserDTO create(AppUserDetailedDTO appUserDetailedDTO);
    AppUserDTO updateById(UUID id, AppUserDetailedDTO appUserDetailedDTO);
    AppUserDTO patchById(UUID id, AppUserDetailedDTO appUserDetailedDTO);
    AppUserDTO findByUsername(String username);
    AppUserDTO findById(UUID id);
    List<AppUserDTO> findAll();
    void deleteById(UUID id);
}
