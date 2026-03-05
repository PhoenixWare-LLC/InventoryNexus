package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.appuser.AppUserDTO;
import com.phoenixware.inventorynexus.shared.dto.appuser.AppUserDetailedDTO;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/12/26
 */
public interface AppUserService {
    AppUserDTO createAppUser(AppUserDetailedDTO appUserDetailedDTO);
    AppUserDTO getAppUser(String username);
}
