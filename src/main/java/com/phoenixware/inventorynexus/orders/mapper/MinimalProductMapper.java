package com.phoenixware.inventorynexus.orders.mapper;

import com.phoenixware.inventorynexus.orders.dto.minimalproduct.MinimalProductDTO;
import com.phoenixware.inventorynexus.orders.dto.minimalproduct.MinimalProductDetailedDTO;
import com.phoenixware.inventorynexus.orders.entity.MinimalProduct;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Mapper
public interface MinimalProductMapper {

    MinimalProduct mapFromDto(MinimalProductDTO minimalProductDTO);
    MinimalProduct mapFromDetailedDto(MinimalProductDetailedDTO minimalProductDetailedDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MinimalProduct patchFromDto(MinimalProductDTO minimalProductDTO, @MappingTarget MinimalProduct minimalProduct);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MinimalProductDTO patchToDto(MinimalProduct minimalProduct, @MappingTarget MinimalProductDTO minimalProductDTO);


    MinimalProductDTO mapToDto(MinimalProduct minimalProduct);
    MinimalProductDetailedDTO mapToDetailedDto(MinimalProduct minimalProduct);

}
