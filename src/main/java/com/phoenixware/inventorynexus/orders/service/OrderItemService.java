package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.orderitem.OrderItemDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
public interface OrderItemService {
    OrderItemDTO create(OrderItemDTO orderItemDTO);
    OrderItemDTO updateById(UUID id, OrderItemDTO orderItemDTO);
    OrderItemDTO patchById(UUID id, OrderItemDTO orderItemDTO);
    OrderItemDTO findById(UUID id);
    List<OrderItemDTO> findAll();
    void deleteById(UUID id);
}
