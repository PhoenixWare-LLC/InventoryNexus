package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.shared.dto.appuser.AppUserDTO;
import com.phoenixware.inventorynexus.shared.dto.appuser.AppUserDetailedDTO;
import com.phoenixware.inventorynexus.shared.entity.AppUser;
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
public interface AppUserMapper {
    AppUser appUserDtoToAppUser(AppUserDTO appUserDTO);
    AppUser appUserDetailedDtoToAppUser(AppUserDetailedDTO appUserDetailedDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AppUser patchAppUserFromAppUserDto(AppUserDTO appUserDTO, @MappingTarget AppUser appUser);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AppUser patchAppUserFromAppUserDetailedDto(AppUserDetailedDTO appUserDetailedDTO, @MappingTarget AppUser appUser);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AppUserDTO patchAppUserDtoFromAppUser(AppUser appUser, @MappingTarget AppUserDTO appUserDTO);

    AppUserDTO appUserToAppUserDto(AppUser appUser);

    AppUserDetailedDTO appUserToAppUserDetailedDto(AppUser appUser);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AppUserDetailedDTO patchAppUserDetailedDtoFromAppUser(AppUser appUser, @MappingTarget AppUserDetailedDTO appUserDetailedDTO);
}
