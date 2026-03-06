package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.appuser.AppUserDTO;
import com.phoenixware.inventorynexus.shared.dto.appuser.AppUserDetailedDTO;
import com.phoenixware.inventorynexus.shared.entity.Privilege;
import com.phoenixware.inventorynexus.shared.entity.Role;
import com.phoenixware.inventorynexus.shared.exception.user.UserNotFoundException;
import com.phoenixware.inventorynexus.shared.mapper.AppUserMapper;
import com.phoenixware.inventorynexus.shared.repository.AppUserRepository;
import com.phoenixware.inventorynexus.shared.repository.PrivilegeRepository;
import com.phoenixware.inventorynexus.shared.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/12/26
 */
@Service
@Primary
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final AppUserMapper appUserMapper;
    private final RoleRepository roleRepository;
    private final PrivilegeRepository privilegeRepository;

    /**
     * @param appUserDetailedDTO
     * @return
     */
    @Override
    public AppUserDTO createAppUser(AppUserDetailedDTO appUserDetailedDTO) {
        Set<Role> roles = appUserDetailedDTO.getUserRoles()
                .stream()
                .map(dtoRole ->
                        roleRepository.findById(dtoRole.getId()).
                                orElseThrow(() ->
                                        new IllegalArgumentException("Role not found: " + dtoRole.getId())))
                .collect(Collectors.toSet());

        // Sanitize the input...
        appUserDetailedDTO.setUserRoles(roles);

        Set<Privilege> privileges = appUserDetailedDTO.getUserPrivileges()
                .stream()
                .map(dtoPrivilege ->
                        privilegeRepository.findById(dtoPrivilege.getId())
                                .orElseThrow(() ->
                                        new IllegalArgumentException("Privilege not found: " + dtoPrivilege.getId())))
                .collect(Collectors.toSet());

        // Sanitize the input...
        appUserDetailedDTO.setUserPrivileges(privileges);

        return appUserMapper.appUserToAppUserDto(
                appUserRepository.save(
                        appUserMapper.appUserDetailedDtoToAppUser(appUserDetailedDTO)));
    }

    @Override
    public AppUserDTO getAppUser(String username) {
        return appUserMapper.appUserToAppUserDto(appUserRepository.findByUsername(username).orElseThrow(UserNotFoundException::new));
    }
}
