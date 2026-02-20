package com.phoenixware.inventorynexus.inventory.mapper;

import com.phoenixware.inventorynexus.inventory.dto.product.ProductDTO;
import com.phoenixware.inventorynexus.inventory.dto.product.ProductDetailedDTO;
import com.phoenixware.inventorynexus.inventory.entity.Product;
import org.mapstruct.Mapper;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/16/2026
 */
@Mapper
public interface ProductMapper {

    Product mapFromDetailedDTO(ProductDetailedDTO productDetailedDTO);

    ProductDetailedDTO mapToDetailedDTO(Product product);

    Product mapFromDTO(ProductDTO productDTO);

    ProductDTO mapToDTO(Product product);
}
