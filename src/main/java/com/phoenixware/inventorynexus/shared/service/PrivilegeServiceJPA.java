package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.mapper.PrivilegeMapper;
import com.phoenixware.inventorynexus.shared.repository.PrivilegeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/12/26
 */
@Service
@Primary
@RequiredArgsConstructor
public class PrivilegeServiceJPA implements PrivilegeService {
    private final PrivilegeRepository privilegeRepository;
    private final PrivilegeMapper privilegeMapper;
}
