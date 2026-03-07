package com.phoenixware.inventorynexus.inventory.service;

import com.phoenixware.inventorynexus.inventory.dto.binlocation.BinLocationDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
public interface BinLocationService {
    BinLocationDTO create(BinLocationDTO binLocationDTO);
    BinLocationDTO updateById(UUID id, BinLocationDTO binLocationDTO);
    BinLocationDTO patchById(UUID id, BinLocationDTO binLocationDTO);
    BinLocationDTO findById(UUID id);
    List<BinLocationDTO> findAll();
    void deleteById(UUID id);
}
