package com.phoenixware.inventorynexus.inventory.mapper;

import com.phoenixware.inventorynexus.inventory.dto.product.ProductDTO;
import com.phoenixware.inventorynexus.inventory.dto.product.ProductDetailedDTO;
import com.phoenixware.inventorynexus.inventory.entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/16/2026
 */
@Mapper
public interface ProductMapper {

    Product mapFromDto(ProductDTO productDTO);
    Product mapFromDetailedDto(ProductDetailedDTO productDetailedDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product patchFromDto(ProductDTO productDTO, @MappingTarget Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductDTO patchToDto(Product product, @MappingTarget ProductDTO productDTO);

    ProductDTO mapToDto(Product product);
    ProductDetailedDTO mapToDetailedDto(Product product);


}
