package com.phoenixware.inventorynexus.shared.factory;

import com.phoenixware.inventorynexus.inventory.dto.ProductDTO;
import com.phoenixware.inventorynexus.inventory.entity.Product;
import com.phoenixware.inventorynexus.orders.dto.MinimalProductDTO;
import com.phoenixware.inventorynexus.orders.entity.MinimalProduct;
import com.phoenixware.inventorynexus.shared.dto.BaseProductDTO;
import com.phoenixware.inventorynexus.shared.entity.BaseProduct;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     2/16/2026
 */
@Component
public class BaseProductFactory {

    @ObjectFactory
    public BaseProductDTO createDto(BaseProduct baseProduct) {
        if (baseProduct instanceof Product) {
            return new ProductDTO();
        } else if (baseProduct instanceof MinimalProduct) {
            return new MinimalProductDTO();
        }
        throw new IllegalArgumentException("Unknown BaseProduct type: " + baseProduct.getClass());
    }

    @ObjectFactory
    public BaseProduct createEntity(BaseProductDTO baseProductDTO) {
        if (baseProductDTO instanceof ProductDTO) {
            return new Product();
        } else if (baseProductDTO instanceof MinimalProductDTO) {
            return new MinimalProduct();
        }
        throw new IllegalArgumentException("Unknown BaseProductDTO type: " + baseProductDTO.getClass());
    }
}
