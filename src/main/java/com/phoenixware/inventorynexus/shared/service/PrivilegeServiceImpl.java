package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.privilege.PrivilegeDTO;
import com.phoenixware.inventorynexus.shared.entity.Privilege;
import com.phoenixware.inventorynexus.shared.exception.privilege.PrivilegeNotFoundException;
import com.phoenixware.inventorynexus.shared.mapper.PrivilegeMapper;
import com.phoenixware.inventorynexus.shared.repository.PrivilegeRepository;
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
public class PrivilegeServiceImpl implements PrivilegeService {
    private final PrivilegeRepository privilegeRepository;
    private final PrivilegeMapper privilegeMapper;

    @Override
    public PrivilegeDTO create(PrivilegeDTO privilegeDTO) {
        return privilegeMapper.privilegeToPrivilegeDto(
                privilegeRepository.save(
                        privilegeMapper.privilegeDtoToPrivilege(
                                privilegeDTO
                        )
                )
        );
    }

    @Override
    public PrivilegeDTO updateById(UUID id, PrivilegeDTO privilegeDTO) {
        Privilege existingPrivilege = privilegeRepository.findById(id)
                .orElseThrow(PrivilegeNotFoundException::new);

        Privilege updatedPrivilege = privilegeMapper.privilegeDtoToPrivilege(privilegeDTO);
        updatedPrivilege.setId(id);

        privilegeRepository.save(updatedPrivilege);

        Privilege privilegeFromDb = privilegeRepository.findById(id)
                .orElseThrow(PrivilegeNotFoundException::new);

        return privilegeMapper.privilegeToPrivilegeDto(privilegeFromDb);
    }

    @Override
    public PrivilegeDTO patchById(UUID id, PrivilegeDTO privilegeDTO) {
        Privilege existingPrivilege = privilegeRepository.findById(id)
                .orElseThrow(PrivilegeNotFoundException::new);

        Privilege patchedPrivilege = privilegeMapper.patchPrivilegeFromPrivilegeDto(privilegeDTO, existingPrivilege);

        privilegeRepository.save(patchedPrivilege);

        Privilege privilegeFromDb = privilegeRepository.findById(id)
                .orElseThrow(PrivilegeNotFoundException::new);

        return privilegeMapper.privilegeToPrivilegeDto(privilegeFromDb);
    }

    @Override
    public PrivilegeDTO findById(UUID id) {
        return privilegeMapper.privilegeToPrivilegeDto(
                privilegeRepository.findById(id)
                        .orElseThrow(PrivilegeNotFoundException::new)
        );
    }

    @Override
    public List<PrivilegeDTO> findAll() {
        return privilegeRepository
                .findAll()
                .stream()
                .map(privilegeMapper::privilegeToPrivilegeDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (privilegeRepository.existsById(id)) {
            privilegeRepository.deleteById(id);
        } else {
            throw new PrivilegeNotFoundException();
        }

    }
}
