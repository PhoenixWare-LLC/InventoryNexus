package com.phoenixware.inventorynexus.shared.service;

import com.phoenixware.inventorynexus.shared.dto.asset.AssetDTO;
import com.phoenixware.inventorynexus.shared.entity.Asset;
import com.phoenixware.inventorynexus.shared.exception.asset.AssetNotFoundException;
import com.phoenixware.inventorynexus.shared.mapper.AssetMapper;
import com.phoenixware.inventorynexus.shared.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/16/2026
 */
@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {
    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    @Override
    public AssetDTO create(AssetDTO assetDTO) {
        return assetMapper.assetToAssetDto(assetRepository.save(assetMapper.assetDtoToAsset(assetDTO)));
    }

    @Override
    public AssetDTO updateById(UUID id, AssetDTO assetDTO) {
        Asset existingAsset = assetRepository.findById(id)
                .orElseThrow(AssetNotFoundException::new);

        Asset updatedAsset = assetMapper.assetDtoToAsset(assetDTO);
        updatedAsset.setId(id);

        assetRepository.save(updatedAsset);

        Asset contactFromDb = assetRepository.findById(id)
                .orElseThrow(AssetNotFoundException::new);

        return assetMapper.assetToAssetDto(contactFromDb);
    }

    @Override
    public AssetDTO patchById(UUID id, AssetDTO assetDTO) {
        Asset existingAsset = assetRepository.findById(id)
                .orElseThrow(AssetNotFoundException::new);

        Asset patchedAsset = assetMapper.patchAssetFromAssetDto(assetDTO, existingAsset);

        assetRepository.save(patchedAsset);

        Asset contactFromDb = assetRepository.findById(id)
                .orElseThrow(AssetNotFoundException::new);

        return assetMapper.assetToAssetDto(contactFromDb);
    }

    @Override
    public AssetDTO findById(UUID id) {
        return assetMapper.assetToAssetDto(assetRepository.findById(id).orElseThrow(AssetNotFoundException::new));
    }

    @Override
    public List<AssetDTO> findAll() {
        return  assetRepository
                .findAll()
                .stream()
                .map(assetMapper::assetToAssetDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (assetRepository.existsById(id)) {
            assetRepository.deleteById(id);
        } else {
            throw new AssetNotFoundException();
        }

    }
}
