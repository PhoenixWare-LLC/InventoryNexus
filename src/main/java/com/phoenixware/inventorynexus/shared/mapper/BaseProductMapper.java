package com.phoenixware.inventorynexus.shared.mapper;

import com.phoenixware.inventorynexus.inventory.dto.product.ProductDTO;
import com.phoenixware.inventorynexus.inventory.dto.product.ProductDetailedDTO;
import com.phoenixware.inventorynexus.inventory.entity.Product;
import com.phoenixware.inventorynexus.inventory.mapper.ProductMapper;
import com.phoenixware.inventorynexus.orders.dto.minimalproduct.MinimalProductDTO;
import com.phoenixware.inventorynexus.orders.dto.minimalproduct.MinimalProductDetailedDTO;
import com.phoenixware.inventorynexus.orders.entity.MinimalProduct;
import com.phoenixware.inventorynexus.orders.mapper.MinimalProductMapper;
import com.phoenixware.inventorynexus.shared.dto.baseproduct.BaseProductDTO;
import com.phoenixware.inventorynexus.shared.dto.baseproduct.BaseProductDetailedDTO;
import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import com.phoenixware.inventorynexus.shared.factory.BaseProductFactory;
import org.mapstruct.*;

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

    @SubclassMapping(source = ProductDTO.class, target = Product.class)
    @SubclassMapping(source = MinimalProductDTO.class, target = MinimalProduct.class)
    BaseProduct mapFromDto(BaseProductDTO baseProductDTO);

    @SubclassMapping(source = ProductDetailedDTO.class, target = Product.class)
    @SubclassMapping(source = MinimalProductDetailedDTO.class, target = MinimalProduct.class)
    BaseProduct mapFromDetailedDto(BaseProductDetailedDTO baseProductDetailedDTO);

    // TODO: Once Mapstruct 1.7 is released, this code will compile update mapstruct once released and uncomment
//    @SubclassMapping(source = ProductDTO.class, target = Product.class)
//    @SubclassMapping(source = MinimalProductDTO.class, target = MinimalProduct.class)
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    BaseProduct patchFromDto(BaseProductDTO baseProductDTO, @MappingTarget BaseProduct baseProduct);

    // TODO: Once Mapstruct 1.7 is released, this code will compile update mapstruct once released and uncomment
//    @SubclassMapping(source = Product.class, target = ProductDTO.class)
//    @SubclassMapping(source = MinimalProduct.class, target = MinimalProductDTO.class)
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    BaseProductDTO patchToDto(BaseProduct baseProduct, @MappingTarget BaseProductDTO baseProductDTO);

    @SubclassMapping(source = Product.class, target = ProductDTO.class)
    @SubclassMapping(source = MinimalProduct.class, target = MinimalProductDTO.class)
    BaseProductDTO mapToDto(BaseProduct product);

    @SubclassMapping(source = Product.class, target = ProductDetailedDTO.class)
    @SubclassMapping(source = MinimalProduct.class, target = MinimalProductDetailedDTO.class)
    BaseProductDetailedDTO mapToDetailedDto(BaseProduct baseProduct);
}
