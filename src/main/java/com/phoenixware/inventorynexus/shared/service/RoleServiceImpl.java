package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.role.RoleDTO;
import com.phoenixware.inventorynexus.shared.entity.Role;
import com.phoenixware.inventorynexus.shared.exception.role.RoleNotFoundException;
import com.phoenixware.inventorynexus.shared.mapper.RoleMapper;
import com.phoenixware.inventorynexus.shared.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/12/26
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;


    @Override
    public RoleDTO create(RoleDTO roleDTO) {
        return roleMapper.roleToRoleDto(
                roleRepository.save(
                        roleMapper.roleDtoToRole(roleDTO)
                )
        );
    }

    @Override
    public RoleDTO updateById(UUID id, RoleDTO roleDTO) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(RoleNotFoundException::new);

        Role updatedRole = roleMapper.roleDtoToRole(roleDTO);
        updatedRole.setId(id);

        roleRepository.save(updatedRole);

        Role roleFromDb = roleRepository.findById(id)
                .orElseThrow(RoleNotFoundException::new);

        return roleMapper.roleToRoleDto(roleFromDb);
    }

    @Override
    public RoleDTO patchById(UUID id, RoleDTO roleDTO) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(RoleNotFoundException::new);

        Role patchedRole = roleMapper.patchRoleFromRoleDto(roleDTO, existingRole);

        roleRepository.save(patchedRole);

        Role roleFromDb = roleRepository.findById(id)
                .orElseThrow(RoleNotFoundException::new);

        return roleMapper.roleToRoleDto(roleFromDb);
    }

    @Override
    public RoleDTO findById(UUID id, RoleDTO roleDTO) {
        return roleMapper.roleToRoleDto(
                roleRepository.findById(id)
                        .orElseThrow(RoleNotFoundException::new)
        );
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleRepository
                .findAll()
                .stream()
                .map(roleMapper::roleToRoleDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        } else {
            throw new RoleNotFoundException();
        }

    }
}
