package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.order.OrderDetailedDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
public interface OrderService {
    OrderDetailedDTO create(OrderDetailedDTO orderDetailedDTO);
    OrderDetailedDTO updateById(UUID id, OrderDetailedDTO orderDetailedDTO);
    OrderDetailedDTO patchById(UUID id, OrderDetailedDTO orderDetailedDTO);
    OrderDetailedDTO findById(UUID id);
    List<OrderDetailedDTO> findAll();
    void deleteById(UUID id);
}
