package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.inventory.dto.ProductDTO;
import com.phoenixware.inventorynexus.inventory.entity.Product;
import com.phoenixware.inventorynexus.inventory.mapper.ProductMapper;
import com.phoenixware.inventorynexus.orders.dto.MinimalProductDTO;
import com.phoenixware.inventorynexus.orders.entity.MinimalProduct;
import com.phoenixware.inventorynexus.orders.mapper.MinimalProductMapper;
import com.phoenixware.inventorynexus.shared.dto.BaseProductDTO;
import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import com.phoenixware.inventorynexus.shared.factory.BaseProductFactory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.SubclassMapping;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/14/2026
 */
@Mapper(uses = {
        BaseProductFactory.class,
        MinimalProductMapper.class,
        ProductMapper.class
},
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseProductMapper {
    @SubclassMapping(source = Product.class, target = ProductDTO.class)
    @SubclassMapping(source = MinimalProduct.class, target = MinimalProductDTO.class)
    BaseProductDTO mapToDTO(BaseProduct product);


    @SubclassMapping(source = ProductDTO.class, target = Product.class)
    @SubclassMapping(source = MinimalProductDTO.class, target = MinimalProduct.class)
    BaseProduct mapFromDTO(BaseProductDTO baseProductDTO);
}
