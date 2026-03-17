package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.shared.dto.asset.AssetDTO;
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

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Asset patchAssetFromAssetDto(AssetDTO assetDTO, @MappingTarget Asset asset);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetDTO patchAssetDtoFromAsset(Asset asset, @MappingTarget AssetDTO assetDTO);

    AssetDTO assetToAssetDto(Asset asset);

}
