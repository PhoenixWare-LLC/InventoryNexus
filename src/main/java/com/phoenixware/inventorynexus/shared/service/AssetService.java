package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.asset.AssetDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/16/2026
 */
public interface AssetService {
    AssetDTO create(AssetDTO assetDTO);
    AssetDTO updateById(UUID id, AssetDTO assetDTO);
    AssetDTO patchById(UUID id, AssetDTO assetDTO);
    AssetDTO findById(UUID id);
    List<AssetDTO> findAll();
    void deleteById(UUID id);
}
