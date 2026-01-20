package com.phoenixware.inventorynexus.orders.mapper;

import com.phoenixware.inventorynexus.orders.dto.MinimalProductDTO;
import com.phoenixware.inventorynexus.orders.entity.MinimalProduct;
import org.mapstruct.Mapper;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Mapper
public interface MinimalProductMapper {

    MinimalProduct minimalProductDtoToMinimalProduct(MinimalProductDTO minimalProductDTO);

    MinimalProductDTO minimalProductToMinimalProductDto(MinimalProduct minimalProduct);

}
