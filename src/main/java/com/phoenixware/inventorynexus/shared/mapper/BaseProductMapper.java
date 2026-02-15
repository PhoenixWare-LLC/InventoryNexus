package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.inventory.dto.ProductDTO;
import com.phoenixware.inventorynexus.inventory.entity.Product;
import com.phoenixware.inventorynexus.orders.dto.MinimalProductDTO;
import com.phoenixware.inventorynexus.orders.entity.MinimalProduct;
import com.phoenixware.inventorynexus.shared.dto.BaseProductDTO;
import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/14/2026
 */
@Mapper
public interface BaseProductMapper {
    @SubclassMapping(source = Product.class, target = ProductDTO.class)
    @SubclassMapping(source = MinimalProduct.class, target = MinimalProductDTO.class)
    BaseProductDTO baseProductToBaseProductDTO(BaseProduct product);


    @SubclassMapping(source = Product.class, target = ProductDTO.class)
    @SubclassMapping(source = MinimalProduct.class, target = MinimalProductDTO.class)
    BaseProduct baseProductDTOToBaseProduct(BaseProductDTO baseProductDTO);
}
