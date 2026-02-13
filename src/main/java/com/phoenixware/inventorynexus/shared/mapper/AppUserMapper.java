package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.shared.dto.AppUserDTO;
import com.phoenixware.inventorynexus.shared.entity.AppUser;
import org.mapstruct.Mapper;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     02/12/2026
 */
@Mapper
public interface AppUserMapper {
    AppUser appUserDtoToAppUser(AppUserDTO appUserDTO);

    AppUserDTO appUserToAppUserDto(AppUser appUser);
}
