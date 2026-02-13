package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.mapper.RoleMapper;
import com.phoenixware.inventorynexus.shared.repository.RoleRepository;
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
public class RoleServiceJPA implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
}
