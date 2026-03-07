package com.phoenixware.inventorynexus.inventory.service;

import com.phoenixware.inventorynexus.inventory.dto.productlocation.ProductLocationDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/6/2026
 */
public interface ProductLocationService {
    ProductLocationDTO create(ProductLocationDTO productLocationDTO);
    ProductLocationDTO updateById(UUID id, ProductLocationDTO productLocationDTO);
    ProductLocationDTO patchById(UUID id, ProductLocationDTO productLocationDTO);
    ProductLocationDTO findById(UUID id);
    List<ProductLocationDTO> findAll();
    void deleteById(UUID id);
}
