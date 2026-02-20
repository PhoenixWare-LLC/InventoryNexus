package com.phoenixware.inventorynexus.shared.factory;

import com.phoenixware.inventorynexus.inventory.dto.product.ProductDTO;
import com.phoenixware.inventorynexus.inventory.dto.product.ProductDetailedDTO;
import com.phoenixware.inventorynexus.inventory.entity.Product;
import com.phoenixware.inventorynexus.orders.dto.minimalproduct.MinimalProductDTO;
import com.phoenixware.inventorynexus.orders.dto.minimalproduct.MinimalProductDetailedDTO;
import com.phoenixware.inventorynexus.orders.entity.MinimalProduct;
import com.phoenixware.inventorynexus.shared.dto.baseproduct.BaseProductDTO;
import com.phoenixware.inventorynexus.shared.dto.baseproduct.BaseProductDetailedDTO;
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
    public BaseProductDetailedDTO createDetailedDto(BaseProduct baseProduct) {
        if (baseProduct instanceof Product) {
            return new ProductDetailedDTO();
        } else if (baseProduct instanceof MinimalProduct) {
            return new MinimalProductDetailedDTO();
        }
        throw new IllegalArgumentException("Unknown BaseProduct type: " + baseProduct.getClass());
    }

    @ObjectFactory
    public BaseProduct createDetailedEntity (BaseProductDetailedDTO baseProductDetailedDTO) {
        if (baseProductDetailedDTO instanceof ProductDetailedDTO) {
            return new Product();
        } else if (baseProductDetailedDTO instanceof MinimalProductDetailedDTO) {
            return new MinimalProduct();
        }
        throw new IllegalArgumentException("Unknown BaseProductDetailedDTO type: " + baseProductDetailedDTO.getClass());
    }

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
