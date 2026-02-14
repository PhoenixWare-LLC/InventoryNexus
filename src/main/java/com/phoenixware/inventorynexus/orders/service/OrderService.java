package com.phoenixware.inventorynexus.orders.service;

import com.phoenixware.inventorynexus.orders.dto.OrderDTO;

import java.util.List;
import java.util.UUID;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
public interface OrderService {
    List<OrderDTO> getUnshippedOrders();

    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(UUID id);

    OrderDTO patchOrderById(UUID orderId, OrderDTO orderDTO);

    void deleteById(UUID orderId);

    OrderDTO putById(UUID orderId, OrderDTO orderDTO);

    OrderDTO saveNewOrder(OrderDTO orderDTO);


}
