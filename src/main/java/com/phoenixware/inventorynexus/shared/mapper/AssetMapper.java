package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.shared.dto.asset.AssetDTO;
import com.phoenixware.inventorynexus.shared.dto.asset.AssetWithDataDTO;
import com.phoenixware.inventorynexus.shared.entity.Asset;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/16/2026
 */
@Mapper
public interface AssetMapper {

    Asset assetDtoToAsset(AssetDTO assetDTO);

    Asset assetWithDataDtoToAsset(AssetWithDataDTO assetWithDataDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Asset patchAssetFromAssetDto(AssetDTO assetDTO, @MappingTarget Asset asset);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Asset patchAssetFromAssetWithDataDto(AssetWithDataDTO assetWithDataDTO, @MappingTarget Asset asset);

    AssetDTO assetToAssetDto(Asset asset);

    AssetDTO assetWithDataToAssetDto(AssetWithDataDTO assetWithDataDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetDTO patchAssetDtoFromAsset(Asset asset, @MappingTarget AssetDTO assetDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetDTO patchAssetDtoFromAssetWithDataDTO(AssetWithDataDTO assetWithDataDTO, @MappingTarget AssetDTO assetDTO);

    AssetWithDataDTO assetToAssetWithDataDto(Asset asset);

    AssetWithDataDTO assetDtoToAssetWithDataDto(AssetDTO assetDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetWithDataDTO patchAssetWithDataDtoFromAsset(Asset asset, @MappingTarget AssetWithDataDTO assetWithDataDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetWithDataDTO patchAssetWithDataDtoFromAssetDto(AssetDTO assetDTO, @MappingTarget AssetWithDataDTO assetWithDataDTO);

}
