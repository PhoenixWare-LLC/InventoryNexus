package com.phoenixware.inventorynexus.inventory.mapper;

import com.phoenixware.inventorynexus.inventory.dto.ProductDTO;
import com.phoenixware.inventorynexus.inventory.entity.Product;
import org.mapstruct.Mapper;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/16/2026
 */
@Mapper
public interface ProductMapper {

    Product mapFromDTO(ProductDTO productDTO);

    ProductDTO mapToDTO(Product product);
}
