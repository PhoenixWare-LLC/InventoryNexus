package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.asset.AssetDTO;
import com.phoenixware.inventorynexus.shared.dto.asset.AssetWithDataDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/16/2026
 */
public interface AssetService {
    AssetWithDataDTO create(AssetDTO assetDTO, MultipartFile multipartFile);
    AssetWithDataDTO updateById(UUID id, AssetDTO assetDTO, MultipartFile multipartFile);
    AssetWithDataDTO patchById(UUID id, AssetDTO assetDTO, MultipartFile multipartFile);
    AssetWithDataDTO findById(UUID id);
    List<AssetWithDataDTO> findAll();
    void deleteById(UUID id);
}
