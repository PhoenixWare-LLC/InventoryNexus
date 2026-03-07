package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.shared.dto.baseproduct.BaseProductDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
public interface MinimalProductService {
    BaseProductDTO create(BaseProductDTO baseProductDTO);
    BaseProductDTO updateById(UUID id, BaseProductDTO baseProductDTO);
    BaseProductDTO patchById(UUID id, BaseProductDTO baseProductDTO);
    BaseProductDTO findById(UUID id);
    List<BaseProductDTO> findAll();
    void deleteById(UUID id);
}
