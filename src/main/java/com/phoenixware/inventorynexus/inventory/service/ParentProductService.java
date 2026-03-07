package com.phoenixware.inventorynexus.inventory.service;

import com.phoenixware.inventorynexus.inventory.dto.parentproduct.ParentProductDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
public interface ParentProductService {
    ParentProductDTO create(ParentProductDTO productDTO);
    ParentProductDTO updateById(UUID id, ParentProductDTO productDTO);
    ParentProductDTO patchById(UUID id, ParentProductDTO productDTO);
    ParentProductDTO findById(UUID id);
    List<ParentProductDTO> findAll();
    void deleteById(UUID id);
}
