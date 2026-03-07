package com.phoenixware.inventorynexus.inventory.mapper;

import com.phoenixware.inventorynexus.inventory.dto.parentproduct.ParentProductDTO;
import com.phoenixware.inventorynexus.inventory.entity.ParentProduct;
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
public interface ParentProductMapper {
    ParentProduct parentProductDtoToParentProduct(ParentProductDTO productDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ParentProduct patchParentProductFromParentProductDto(ParentProductDTO parentProductDTO, @MappingTarget ParentProduct parentProduct);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ParentProductDTO patchParentProductDtoFromParentProduct(ParentProduct parentProduct, @MappingTarget ParentProductDTO parentProductDTO);

    ParentProductDTO parentProductToParentProductDto(ParentProduct parentProduct);
}
