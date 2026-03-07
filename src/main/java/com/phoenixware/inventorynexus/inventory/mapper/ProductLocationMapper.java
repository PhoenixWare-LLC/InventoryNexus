package com.phoenixware.inventorynexus.inventory.mapper;

import com.phoenixware.inventorynexus.inventory.dto.productlocation.ProductLocationDTO;
import com.phoenixware.inventorynexus.inventory.entity.ProductLocation;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
@Mapper
public interface ProductLocationMapper {
    ProductLocation productLocationDtoToProductLocation(ProductLocationDTO productLocationDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductLocation patchProductLocationFromProductLocationDto(ProductLocationDTO productLocationDTO, @MappingTarget ProductLocation productLocation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductLocationDTO patchProductLocationDtoFromProductLocation(ProductLocation productLocation, @MappingTarget ProductLocationDTO productLocationDTO);

    ProductLocationDTO productLocationToProductLocationDto(ProductLocation productLocation);
}
