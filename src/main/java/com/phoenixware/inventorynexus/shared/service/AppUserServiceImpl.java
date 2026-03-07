package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.appuser.AppUserDTO;
import com.phoenixware.inventorynexus.shared.dto.appuser.AppUserDetailedDTO;
import com.phoenixware.inventorynexus.shared.entity.AppUser;
import com.phoenixware.inventorynexus.shared.entity.Privilege;
import com.phoenixware.inventorynexus.shared.entity.Role;
import com.phoenixware.inventorynexus.shared.exception.appuser.AppUserNotFoundException;
import com.phoenixware.inventorynexus.shared.mapper.AppUserMapper;
import com.phoenixware.inventorynexus.shared.repository.AppUserRepository;
import com.phoenixware.inventorynexus.shared.repository.PrivilegeRepository;
import com.phoenixware.inventorynexus.shared.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/12/26
 */
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final AppUserMapper appUserMapper;
    private final RoleRepository roleRepository;
    private final PrivilegeRepository privilegeRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * @param appUserDetailedDTO
     * @return
     */
    @Override
    public AppUserDTO create(AppUserDetailedDTO appUserDetailedDTO) {

        // Sanitize the input...
        appUserDetailedDTO.setUserRoles(
                sanitizeRoles(appUserDetailedDTO.getUserRoles())
        );

        // Sanitize the input...
        appUserDetailedDTO.setUserPrivileges(
                sanitizePrivileges(
                        appUserDetailedDTO.getUserPrivileges()
                )
        );

        // Hash that password
        appUserDetailedDTO.setPassword(
                passwordEncoder.encode(
                        appUserDetailedDTO.getPassword()
                )
        );

        return appUserMapper.appUserToAppUserDto(
                appUserRepository.save(
                        appUserMapper.appUserDetailedDtoToAppUser(appUserDetailedDTO)));
    }

    @Override
    public AppUserDTO updateById(UUID id, AppUserDetailedDTO appUserDetailedDTO) {
        AppUser existingAppUser = appUserRepository.findById(id)
                .orElseThrow(AppUserNotFoundException::new);

        // sanitize that input
        if (!appUserDetailedDTO.getUserRoles().isEmpty()) {
            appUserDetailedDTO.setUserRoles(
                    sanitizeRoles(
                            appUserDetailedDTO.getUserRoles()
                    )
            );
        }

        // sanitize that input
        if (!appUserDetailedDTO.getUserPrivileges().isEmpty()) {
            appUserDetailedDTO.setUserPrivileges(
                    sanitizePrivileges(
                            appUserDetailedDTO.getUserPrivileges()
                    )
            );
        }

        // make sure we don't mistakenly get rid of the password
        if (!appUserDetailedDTO.getPassword().isEmpty()) {
            appUserDetailedDTO.setPassword(passwordEncoder.encode(appUserDetailedDTO.getPassword()));
        } else {
            appUserDetailedDTO.setPassword(existingAppUser.getPassword());
        }

        AppUser updatedAppUser = appUserMapper.appUserDetailedDtoToAppUser(appUserDetailedDTO);
        updatedAppUser.setId(id);

        appUserRepository.save(updatedAppUser);

        AppUser appUserFromDb = appUserRepository.findById(id)
                .orElseThrow(AppUserNotFoundException::new);

        return appUserMapper.appUserToAppUserDto(appUserFromDb);
    }

    @Override
    public AppUserDTO patchById(UUID id, AppUserDetailedDTO appUserDetailedDTO) {
        AppUser existingAppUser = appUserRepository.findById(id)
                .orElseThrow(AppUserNotFoundException::new);

        if (!appUserDetailedDTO.getUserRoles().isEmpty()) {
            appUserDetailedDTO.setUserRoles(
                    sanitizeRoles(
                            appUserDetailedDTO.getUserRoles()
                    )
            );
        }

        if (!appUserDetailedDTO.getUserPrivileges().isEmpty()) {
            appUserDetailedDTO.setUserPrivileges(
                    sanitizePrivileges(
                            appUserDetailedDTO.getUserPrivileges()
                    )
            );
        }

        if (!appUserDetailedDTO.getPassword().isEmpty()) {
            appUserDetailedDTO.setPassword(passwordEncoder.encode(appUserDetailedDTO.getPassword()));
        }

        AppUser patchedAppUser = appUserMapper.patchAppUserFromAppUserDetailedDto(appUserDetailedDTO, existingAppUser);

        appUserRepository.save(patchedAppUser);

        AppUser appUserFromDb = appUserRepository.findById(id)
                .orElseThrow(AppUserNotFoundException::new);

        return appUserMapper.appUserToAppUserDto(appUserFromDb);
    }

    @Override
    public AppUserDTO findByUsername(String username) {
        return appUserMapper.appUserToAppUserDto(
                appUserRepository.findByUsername(username).
                        orElseThrow(AppUserNotFoundException::new)
        );
    }

    @Override
    public AppUserDTO findById(UUID id) {
        return appUserMapper.appUserToAppUserDto(
                appUserRepository.findById(id)
                        .orElseThrow(AppUserNotFoundException::new)
        );
    }

    @Override
    public List<AppUserDTO> findAll() {
        return appUserRepository
                .findAll()
                .stream()
                .map(appUserMapper::appUserToAppUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (appUserRepository.existsById(id)) {
            appUserRepository.deleteById(id);
        } else {
            throw new AppUserNotFoundException();
        }
    }

    private Set<Role> sanitizeRoles(Set<Role> roles) {
        Set<Role> sanitizedRoles = roles
                .stream()
                .map(dtoRole ->
                        roleRepository.findById(dtoRole.getId()).
                                orElseThrow(() ->
                                        new IllegalArgumentException("Role not found: " + dtoRole.getId())))
                .collect(Collectors.toSet());

        // Sanitize the input...
        return sanitizedRoles;

    }

    private Set<Privilege> sanitizePrivileges(Set<Privilege> privileges) {
        Set<Privilege> sanitizedPrivileges = privileges
                .stream()
                .map(dtoPrivilege ->
                        privilegeRepository.findById(dtoPrivilege.getId())
                                .orElseThrow(() ->
                                        new IllegalArgumentException("Privilege not found: " + dtoPrivilege.getId())))
                .collect(Collectors.toSet());

        // Sanitize the input...
        return sanitizedPrivileges;
    }
}
